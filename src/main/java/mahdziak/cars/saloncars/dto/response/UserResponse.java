package mahdziak.cars.saloncars.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mahdziak.cars.saloncars.entity.User;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private Long id;

    private String name;

    private String lastName;

    private Integer year;

    private String email;

    public UserResponse(User user) {
      id = user.getId();
      name = user.getName();
      lastName = user.getLastName();
      year = user.getYear();
      email = user.getEmail();
    }
}
