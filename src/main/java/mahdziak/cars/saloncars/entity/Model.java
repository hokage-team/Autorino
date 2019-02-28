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
@Table(name = "_model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;

    @OneToMany(mappedBy = "model")
    private List<Car> cars = new ArrayList<>();

    @ManyToOne
    private Make make;
}
