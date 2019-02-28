package mahdziak.cars.saloncars.controller;


import mahdziak.cars.saloncars.dto.request.MakeRequest;
import mahdziak.cars.saloncars.dto.request.PaginationRequest;
import mahdziak.cars.saloncars.dto.response.DataResponse;
import mahdziak.cars.saloncars.dto.response.MakeResponse;
import mahdziak.cars.saloncars.exception.WrongInputException;
import mahdziak.cars.saloncars.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/make")
public class MakeController {


    @Autowired
    private MakeService makeService;

    @GetMapping
    public List<MakeResponse> findAll() {
        return makeService.findAll();
    }

    @PostMapping
    public MakeResponse save( @Valid @RequestBody MakeRequest makeRequest) {
        return makeService.save(makeRequest);
    }



    @PostMapping("/page")
    public DataResponse<MakeResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
        return makeService.findAll(paginationRequest);
    }


    @PutMapping
    public MakeResponse update(@RequestBody MakeRequest makeRequest, @RequestParam Long id) throws WrongInputException {
        return makeService.update(makeRequest, id);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        makeService.delete(id);
    }
}
