package voss.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import voss.dao.DAO;
import voss.domain.ProductMaster;
import voss.domain.UserEntity;
import voss.entity.BankMasterEntity;
import voss.repository.BankMasterRepository;


@Controller
public class VossController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private ApplicationContext appContext;

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
    @RequestMapping("/getProducts")
    @ResponseBody
    public List<ProductMaster> getProducts()
    {
		DAO dao = new DAO();
		return dao.getProducts();
    }
    @RequestMapping("/getBankMaster")
    @ResponseBody
    public List<BankMasterEntity> getBankMaster()
    {
    	List<BankMasterEntity> bm = new ArrayList<BankMasterEntity>();
    	BankMasterRepository bmr = appContext.getBean(BankMasterRepository.class);
    	bm = bmr.findAll();
    	return bm;
    }
    @RequestMapping("/addBank")
    @ResponseBody
    public BankMasterEntity addBank(@RequestBody BankMasterEntity bankMaster)
    {
    	//BankMasterRepository bmr = appContext.getBean(BankMasterRepository.class);
    	//bmr.save(bankMaster);
    	return bankMaster;
    }
}
