package akademiakodu.ormtest.controllers;

import akademiakodu.ormtest.models.UserModel;
import akademiakodu.ormtest.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/")
    @ResponseBody
    public String index(){
        UserModel someUserModel = userRepository.findOne(2);
        return someUserModel.toString();
    }


}
