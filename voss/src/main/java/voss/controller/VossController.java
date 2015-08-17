package voss.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import voss.dao.DAO;
import voss.domain.UserEntity;


@Controller
public class VossController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/user")
    @ResponseBody
    public  String user(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello "+name;
    }
    
    @RequestMapping("/home")
    public  String home() {
        return "index";
    }
    @RequestMapping("/UserRegistration")
    public  String userRegistration() {
        return "regist";
    }
    @RequestMapping("/addUsers")
    @ResponseBody
    public String addUsers(@RequestBody UserEntity user)
    {
		DAO dao = new DAO();
		dao.addUsers(user);
		return null;
    }
}
