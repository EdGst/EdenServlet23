package technifutur.be.technifutur.models.ConnectedUserDtos;

import lombok.*;
import technifutur.be.technifutur.models.entities.User;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectedUserDto {

    private Integer id;
    private String login;

    public static ConnectedUserDto fromEntity(User user){

        return ConnectedUserDto.builder().id(user.getId()).login(user.getUsername()).build();
    }

}