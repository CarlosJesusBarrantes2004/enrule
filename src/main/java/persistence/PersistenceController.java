package persistence;

import java.util.logging.Level;
import java.util.logging.Logger;
import logic.CompanyUser;
import logic.NormalUser;
import logic.User;

public class PersistenceController {

    UserJpaController useJpa = new UserJpaController();
    NormalUserJpaController useNJpa = new NormalUserJpaController();
    CompanyUserJpaController useCJpa = new CompanyUserJpaController();

    //NormalUser
    public void createNormalUser(NormalUser useN) {
        useNJpa.create(useN);
    }

    public NormalUser getNormalUser(int id) {
        return useNJpa.findNormalUser(id);
    }

    public void editNormalUser(NormalUser useN) {
        try {
            useNJpa.edit(useN);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CompanyUser
    public void createCompanyUser(CompanyUser useC) {
        useCJpa.create(useC);
    }

    public CompanyUser getCompanyUser(int id) {
        return useCJpa.findCompanyUser(id);
    }

    public void editCompanyUser(CompanyUser useC) {
        try {
            useCJpa.edit(useC);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //User
    public User getUser(String email, String password) {
        return useJpa.findUser(email, password);
    }
}
