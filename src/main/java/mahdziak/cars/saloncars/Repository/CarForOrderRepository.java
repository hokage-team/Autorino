package mahdziak.cars.saloncars.Repository;

import mahdziak.cars.saloncars.entity.CarForOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarForOrderRepository extends JpaRepository<CarForOrder, Long> {
}
