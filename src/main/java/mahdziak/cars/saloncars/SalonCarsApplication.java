package mahdziak.cars.saloncars;

import mahdziak.cars.saloncars.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SalonCarsApplication {



//
//    @Autowired
//    private CarRepository carRepository;
//
//    @PostConstruct
//    public void init(){

//        Engine engine = new Engine();
//        engine.setPower(200);
//        engine.setVolume(2.2);
//
//        engineRepository.save(engine);
//
//
//
//        Car car = new Car();
//         car.setModel("BMV");
//         car.setYear(2015);
//         car.setEngine(engine);
//
//          carRepository.save(car);
//

//          carRepository.findAll().forEach(System.out::println);


//    }

    public static void main(String[] args) {
        SpringApplication.run(SalonCarsApplication.class, args);
    }


}
