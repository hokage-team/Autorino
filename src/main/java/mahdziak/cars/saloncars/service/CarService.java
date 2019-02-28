package mahdziak.cars.saloncars.service;

import mahdziak.cars.saloncars.Repository.CarRepository;
import mahdziak.cars.saloncars.dto.request.CarFilterRequest;
import mahdziak.cars.saloncars.dto.request.CarRequest;
import mahdziak.cars.saloncars.dto.response.CarResponse;
import mahdziak.cars.saloncars.dto.response.DataResponse;
import mahdziak.cars.saloncars.entity.Car;
import mahdziak.cars.saloncars.exception.WrongInputException;
import mahdziak.cars.saloncars.specification.CarSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CountryService countryService;

    public CarResponse save(CarRequest carRequest) throws WrongInputException {
        return new CarResponse(carRequestToCar(null, carRequest));
    }

    public CarResponse update(Long id, CarRequest carRequest) throws WrongInputException {
        return new CarResponse(carRequestToCar(findOne(id), carRequest));
    }

    public List<CarResponse> findAll() {
        return carRepository.findAll().stream().map(CarResponse::new).collect(Collectors.toList());
    }

//    public DataResponse<CarResponse> findByFilter(CarFilterRequest filterRequest) {
//        Page<Car> page = carRepository.findAll(
//                new CarSpecification(filterRequest),
//                filterRequest.getPagination().mapToPageRequest());
//
//        return new DataResponse<>(page.get().map(CarResponse::new).collect(Collectors.toList()), page.getTotalPages(), page.getTotalElements());
//
//    }

    public void delete(Long id) throws WrongInputException {
        carRepository.delete(findOne(id));
    }

    public Car findOne(Long id) throws WrongInputException {
        return carRepository.findById(id).orElseThrow(() -> new WrongInputException("Car with id " + id + " not exists"));
    }

    private Car carRequestToCar(Car car, CarRequest request) throws WrongInputException {
        if (car == null) {
            car = new Car();
        }
        car.setCountry(countryService.findOne(request.getCountryId()));
        car.setName(request.getName());
        car.setYear(request.getYear());
        car.setPrice(request.getPrice());

        return carRepository.save(car);
    }

}
