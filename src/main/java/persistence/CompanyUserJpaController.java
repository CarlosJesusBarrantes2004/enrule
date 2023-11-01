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
import logic.CompanyUser;
import org.mindrot.jbcrypt.BCrypt;
import persistence.exceptions.NonexistentEntityException;

public class CompanyUserJpaController implements Serializable {

    public CompanyUserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CompanyUserJpaController() {
        this.emf = Persistence.createEntityManagerFactory("PU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CompanyUser companyUser) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(companyUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CompanyUser companyUser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            companyUser = em.merge(companyUser);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = companyUser.getId();
                if (findCompanyUser(id) == null) {
                    throw new NonexistentEntityException("The companyUser with id " + id + " no longer exists.");
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
            CompanyUser companyUser;
            try {
                companyUser = em.getReference(CompanyUser.class, id);
                companyUser.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The companyUser with id " + id + " no longer exists.", enfe);
            }
            em.remove(companyUser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CompanyUser> findCompanyUserEntities() {
        return findCompanyUserEntities(true, -1, -1);
    }

    public List<CompanyUser> findCompanyUserEntities(int maxResults, int firstResult) {
        return findCompanyUserEntities(false, maxResults, firstResult);
    }

    private List<CompanyUser> findCompanyUserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CompanyUser.class));
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

    public CompanyUser findCompanyUser(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CompanyUser.class, id);
        } finally {
            em.close();
        }
    }

    public CompanyUser findCompanyUser(String email, String password) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT uc FROM CompanyUser uc WHERE uc.email = :email");
            query.setParameter("email", email);

            CompanyUser useC = (CompanyUser) query.getSingleResult();

            if (BCrypt.checkpw(password, useC.getHashedPassword())) {
                return useC;
            }

            return null;
        } finally {
            em.close();
        }
    }

    public int getCompanyUserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CompanyUser> rt = cq.from(CompanyUser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
