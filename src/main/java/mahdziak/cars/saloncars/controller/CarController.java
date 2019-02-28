package mahdziak.cars.saloncars.controller;

import mahdziak.cars.saloncars.dto.request.CarFilterRequest;
import mahdziak.cars.saloncars.dto.request.CarRequest;
import mahdziak.cars.saloncars.dto.response.CarResponse;
import mahdziak.cars.saloncars.dto.response.DataResponse;
import mahdziak.cars.saloncars.exception.WrongInputException;
import mahdziak.cars.saloncars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<CarResponse> findAll() {
        return carService.findAll();
    }

//
//    @PostMapping("/filter")
//    public DataResponse<CarResponse> findAllByFilter(@RequestBody CarFilterRequest carFilterRequest) {
//        return carService.findByFilter(carFilterRequest);
//    }

    @PostMapping
    public CarResponse save(@RequestBody CarRequest carRequest) throws WrongInputException {
        return carService.save(carRequest);
    }

    @PutMapping
    public CarResponse Update(@RequestParam Long id, @RequestBody CarRequest carRequest) throws WrongInputException {
        return carService.update(id, carRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        carService.delete(id);
    }
}

