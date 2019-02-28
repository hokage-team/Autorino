package mahdziak.cars.saloncars.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mahdziak.cars.saloncars.entity.Car;

@Getter
@Setter
@NoArgsConstructor

public class CarResponse {
    private Long id;

    private String name;

    private String model;

    private Integer year;

    private Integer price;

    private String usedCar;

    private String countryName;

    public CarResponse(Car car) {
       id = car.getId();
        name = car.getName();
       year = car.getYear();
       price = car.getPrice();
    }
}
