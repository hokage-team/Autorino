package mahdziak.cars.saloncars.controller;

import mahdziak.cars.saloncars.dto.request.CountryRequest;
import mahdziak.cars.saloncars.dto.response.CountryResponse;
import mahdziak.cars.saloncars.exception.WrongInputException;
import mahdziak.cars.saloncars.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<CountryResponse> findAll() {
        return countryService.findAll();
    }

    @PostMapping
    public CountryResponse save(@RequestBody CountryRequest countryRequest) {
        return countryService.save(countryRequest);
    }

    @PutMapping
    public CountryResponse update(@RequestBody CountryRequest countryRequest, @RequestParam Long id) throws WrongInputException {
        return countryService.update(countryRequest, id);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        countryService.delete(id);
    }
}
