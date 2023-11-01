package persistence;

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

    //CompanyUser
    public void createCompanyUser(CompanyUser useC) {
        useCJpa.create(useC);
    }

    public CompanyUser getCompanyUser(int id) {
        return useCJpa.findCompanyUser(id);
    }

    public User getUser(String email, String password) {
        return useJpa.findUser(email, password);
    }
}