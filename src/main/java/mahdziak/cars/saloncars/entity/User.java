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
//@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private Integer year;

    private String email;

    private String password;




    @OneToMany(mappedBy = "user")
    private List<Car> cars = new ArrayList<>();


    @ManyToOne
    private Country country;






}
