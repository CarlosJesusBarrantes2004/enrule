package logic;

import persistence.NormalUserJpaController;

public class UserFollowService {

    private NormalUserJpaController useNJpa;
    
    public UserFollowService(NormalUserJpaController useNJpa) {
        this.useNJpa = useNJpa;
    }
    
    public void seguirUsuario(NormalUser follower, User following) {
        follower.getFollowedUsers().add(following);
        try {
            useNJpa.edit(follower);
        } catch (Exception ex) {
            // Manejar la excepción según tus necesidades
        }
    }
}
