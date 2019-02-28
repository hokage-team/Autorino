package mahdziak.cars.saloncars.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private String name;

    private String lastName;

    private Integer year;

    private String email;


}
