package mahdziak.cars.saloncars.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer year;

    private Integer price;

    private String condition;

    private Integer power;

    private Double volume;

    @ManyToOne
    private User user;

    @ManyToOne
    private Country country;

    @ManyToOne
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<CarForOrder> carsForOrder = new ArrayList<>();



}
