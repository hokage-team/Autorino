package mahdziak.cars.saloncars.service;

import mahdziak.cars.saloncars.Repository.UserRepository;
import mahdziak.cars.saloncars.dto.request.UserRequest;
import mahdziak.cars.saloncars.dto.response.UserResponse;
import mahdziak.cars.saloncars.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserResponse save(UserRequest request){
        User user = new User();
        user.setYear(request.getYear());
        User saved = userRepository.save(user);
        return new UserResponse(saved);
    }

}