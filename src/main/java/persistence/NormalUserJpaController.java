package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logic.NormalUser;
import org.mindrot.jbcrypt.BCrypt;
import persistence.exceptions.NonexistentEntityException;

public class NormalUserJpaController implements Serializable {

    public NormalUserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public NormalUserJpaController() {
        this.emf = Persistence.createEntityManagerFactory("PU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(NormalUser normalUser) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(normalUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NormalUser normalUser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            normalUser = em.merge(normalUser);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = normalUser.getId();
                if (findNormalUser(id) == null) {
                    throw new NonexistentEntityException("The normalUser with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NormalUser normalUser;
            try {
                normalUser = em.getReference(NormalUser.class, id);
                normalUser.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The normalUser with id " + id + " no longer exists.", enfe);
            }
            em.remove(normalUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NormalUser> findNormalUserEntities() {
        return findNormalUserEntities(true, -1, -1);
    }

    public List<NormalUser> findNormalUserEntities(int maxResults, int firstResult) {
        return findNormalUserEntities(false, maxResults, firstResult);
    }

    private List<NormalUser> findNormalUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NormalUser.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public NormalUser findNormalUser(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NormalUser.class, id);
        } finally {
            em.close();
        }
    }

    public NormalUser findNormalUser(String email, String password) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT un FROM NormalUser un WHERE un.email = :email");
            query.setParameter("email", email);

            NormalUser useN = (NormalUser) query.getSingleResult();

            if (BCrypt.checkpw(password, useN.getHashedPassword())) {
                return useN;
            }

            return null;
        } finally {
            em.close();
        }
    }

    public int getNormalUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NormalUser> rt = cq.from(NormalUser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
