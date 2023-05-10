package technifutur.be.technifutur.models.entities;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @EqualsAndHashCode
public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
