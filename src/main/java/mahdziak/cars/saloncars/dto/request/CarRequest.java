package mahdziak.cars.saloncars.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequest {

    private String name;

    private Integer year;

    private Integer price;

    private String usedCar;


    private Long CountryId;

}
