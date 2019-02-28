package mahdziak.cars.saloncars.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CarFilterRequest {

    private Integer yearFrom;
    private Integer yearTo;

    private Double volumeFrom;
    private Double volumeTo;

    private String name;

    private List<Long> countriesId = new ArrayList<>();

    private PaginationRequest pagination;
}
