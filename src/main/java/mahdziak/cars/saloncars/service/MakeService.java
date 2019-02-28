package mahdziak.cars.saloncars.service;
import mahdziak.cars.saloncars.Repository.MakeRepository;
import mahdziak.cars.saloncars.dto.request.MakeRequest;
import mahdziak.cars.saloncars.dto.request.PaginationRequest;
import mahdziak.cars.saloncars.dto.response.DataResponse;
import mahdziak.cars.saloncars.dto.response.MakeResponse;
import mahdziak.cars.saloncars.entity.Make;
import mahdziak.cars.saloncars.exception.WrongInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MakeService {


    @Autowired
    private MakeRepository makeRepository;


    public MakeResponse save(MakeRequest request) {
        return new MakeResponse(makeRequestToMake(request, null));
    }



    public DataResponse<MakeResponse> findAll(PaginationRequest pagination) {
        PageRequest pageRequest = PageRequest.of(pagination.getPage(), pagination.getSize(),
                pagination.getSortRequest().getDirection(), pagination.getSortRequest().getFieldName());

        Page<Make> all = makeRepository.findAll(pageRequest);
        return new DataResponse<>(all.getContent().stream().map(MakeResponse::new).collect(Collectors.toList()),
                all.getTotalPages(), all.getTotalElements());
    }


    private Make makeRequestToMake(MakeRequest request, Make make) {
        if (make == null) {
            make = new Make();
        }
        make.setName(request.getName());
        return makeRepository.save(make);
    }

    public void delete(Long id) throws WrongInputException {
        makeRepository.delete(findOne(id));
    }



    public List<MakeResponse> findAll() {
        return makeRepository.findAll().stream()
                .map(MakeResponse::new)
                .collect(Collectors.toList());
    }

    public MakeResponse update(MakeRequest request, Long id) throws WrongInputException {
        return new MakeResponse(makeRequestToMake(request, findOne(id)));
    }

    public Make findOne(Long id) throws WrongInputException {
        return makeRepository.findById(id)
                .orElseThrow(() -> new WrongInputException("Make with id " + id + " not exists"));
    }




}
