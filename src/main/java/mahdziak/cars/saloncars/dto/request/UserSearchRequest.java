package mahdziak.cars.saloncars.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequest {

    private String name;
    private String email;

    private PaginationRequest paginationRequest;
}
