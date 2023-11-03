package logic;

import persistence.PersistenceController;

public class LogicController {

    PersistenceController controlPersis = new PersistenceController();

    //NormalUser
    public void createNormalUser(NormalUser useN) {
        controlPersis.createNormalUser(useN);
    }

    public NormalUser getNormalUser(int id) {
        return controlPersis.getNormalUser(id);
    }

    public void editNormalUser(NormalUser useN) {
        controlPersis.editNormalUser(useN);
    }

    //CompanyUser
    public void createCompanyUser(CompanyUser useC) {
        controlPersis.createCompanyUser(useC);
    }

    public CompanyUser getCompanyUser(int id) {
        return controlPersis.getCompanyUser(id);
    }

    public void editCompanyUser(CompanyUser useC) {
        controlPersis.editCompanyUser(useC);
    }

    //User
    public User getUser(String email, String password) {
        return controlPersis.getUser(email, password
        );
    }
}
