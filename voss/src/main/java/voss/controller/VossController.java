package voss.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

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
import voss.domain.LoginCred;
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
    @RequestMapping("/")
    public  String login() {
        return "login";
    }
    
    @RequestMapping("/authenticate")
    @ResponseBody
    public int authenticate(@RequestBody LoginCred lc, HttpSession session)
    {
        List<UserEntity> ue = new ArrayList<UserEntity>();
        DAO dao = new DAO();
        ue = dao.getAuthenticatedUser(lc.getUsername(), lc.getPassword());
        //System.out.println(ue.get(0).getName());
        if(ue == null)
        {
            return 0;
        }
        else
        {
            session.setAttribute("name", ue.get(0).getName());
            session.setAttribute("designation",ue.get(0).getDesignation());
            session.setAttribute("reportingManager", ue.get(0).getReportingManager());
            session.setAttribute("username", ue.get(0).getUserName());
            return 1;
        }
        
    }
    
    @RequestMapping("/home")
    public  String home() {
        return "index";
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
