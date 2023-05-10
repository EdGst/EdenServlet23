package technifutur.be.technifutur.models.forms;

import lombok.*;
import technifutur.be.technifutur.models.entities.Client;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientForm {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public ClientForm(Client client) {
        this.firstName = getFirstName();
        this.lastName = getLastName();
        this.email = getEmail();
        this.phoneNumber = getPhoneNumber();
    }

    public Client toEntity(){

        return Client.builder()
                .firstName(getFirstName())
                .lastName(getLastName())
                .email(getEmail())
                .phoneNumber(getPhoneNumber())
                .build();

    }

}
