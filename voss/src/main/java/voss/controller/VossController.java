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
import voss.domain.ProductMaster;
import voss.domain.UserEntity;
import voss.entity.BankMasterEntity;
import voss.entity.BusinessUnitEntity;
import voss.repository.BankMasterRepository;
import voss.repository.BusinessUnitRepository;


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
    @SuppressWarnings("unchecked")
	@RequestMapping("/getBankMaster")
    @ResponseBody
    public List<BankMasterEntity> getBankMaster(
    		@RequestParam(value="page", defaultValue="1") int page,
    		@RequestParam(value="size", defaultValue="10") int size
    		)
    {
    	BankMasterRepository bmr = appContext.getBean(BankMasterRepository.class);
    	PageRequest request = new PageRequest(page-1, size);
    	Page<BankMasterEntity> bm  =  bmr.findAll(request);
    	return bm.getContent();
    }
    @RequestMapping("/getBankMasterSize")
    @ResponseBody
    public int getBankMasterSize()
    {
    	BankMasterRepository bmr = appContext.getBean(BankMasterRepository.class);
    	int i  =  (int) bmr.count();
    	return i;
    }
    @RequestMapping("/getBankByID")
    @ResponseBody
    public BankMasterEntity getBankByID(@RequestParam(value="bankID", defaultValue="1") int  bankID)
    {
        BankMasterEntity bm = new BankMasterEntity();
    	BankMasterRepository bmr = appContext.getBean(BankMasterRepository.class);
    	bm = bmr.findByBankID(bankID);
    	return bm;
    }
    @RequestMapping("/addBank")
    @ResponseBody
    public BankMasterEntity addBank(@RequestBody BankMasterEntity bankMaster)
    {
    	DAO dao = new DAO();
    	dao.insertNewBank(bankMaster);
    	return bankMaster;
    }
    @RequestMapping("/editBank")
    @ResponseBody
    public BankMasterEntity editBank(@RequestBody BankMasterEntity bankMaster)
    {
    	DAO dao = new DAO();
    	dao.editBank(bankMaster);
    	return bankMaster;
    }
    @SuppressWarnings("unchecked")
	@RequestMapping("/getBusinessUnit")
    @ResponseBody
    public List<BusinessUnitEntity> getBusinessUnitMaster(
    		@RequestParam(value="page", defaultValue="1") int page,
    		@RequestParam(value="size", defaultValue="10") int size
    		)
    {
    	BusinessUnitRepository bmr = appContext.getBean(BusinessUnitRepository.class);
    	PageRequest request = new PageRequest(page-1, size);
    	Page<BusinessUnitEntity> bm  =  bmr.findAll(request);
    	return bm.getContent();
    }
}
