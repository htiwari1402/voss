package voss.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import voss.dao.DAO;
import voss.dao.userRegDao;
import voss.domain.Designation;
import voss.domain.ProductMaster;
import voss.domain.UserEntity;
import voss.entity.BankMasterEntity;
import voss.entity.BusinessUnitEntity;
import voss.repository.BankMasterRepository;
import voss.repository.BusinessUnitRepository;


@Controller
public class UserRegistrationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private ApplicationContext appContext;
    
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
    @RequestMapping("/getDesign")
    @ResponseBody
    public List<Designation> getAllDesignations()
    {
		userRegDao dao = new userRegDao();
		List<Designation> des =  dao.getAllDesign();
		return des;
    }
    
    @RequestMapping("/getUser")
    @ResponseBody
    public List<UserEntity> getAllUser()
    {
		userRegDao dao = new userRegDao();
		List<UserEntity> des =  dao.getAllUsers();
		return des;
    }

}
