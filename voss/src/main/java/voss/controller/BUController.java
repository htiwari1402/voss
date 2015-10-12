package voss.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import voss.dao.BUDAO;
import voss.dao.DAO;
import voss.domain.BU;
import voss.domain.LoginCred;
import voss.domain.ProductMaster;
import voss.domain.UserEntity;
import voss.entity.BankMasterEntity;
import voss.entity.BusinessUnitEntity;
import voss.repository.BankMasterRepository;
import voss.repository.BusinessUnitRepository;


@Controller
public class BUController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private ApplicationContext appContext;

    @RequestMapping("/getBUMasterSize")
    @ResponseBody
    public int getBUMasterSize()
    {
    	BUDAO dao = new BUDAO();
    	return dao.getBUMasterSize();
    }
    @RequestMapping("/getBUMaster")
    @ResponseBody
    public List<BusinessUnitEntity> getBUMaster(
    		@RequestParam(value="page", defaultValue="1") int page,
    		@RequestParam(value="size", defaultValue="10") int size
    		)
    {
    	BusinessUnitRepository bmr = appContext.getBean(BusinessUnitRepository.class);
    	PageRequest request = new PageRequest(page-1, size);
    	Page<BusinessUnitEntity> bm  =  bmr.findAll(request);
    	return bm.getContent();
    }
    @RequestMapping("/insertBU")
    @ResponseBody
    public long newBU(@RequestBody BU bu) throws BadSqlGrammarException, SQLException
    {
    	DAO dao = new DAO();
    	long i =  dao.insertNewBU(bu);
    	return i;
    }
    @RequestMapping("/editBU")
    @ResponseBody
    public void editBU(@RequestBody BU bu) throws BadSqlGrammarException, SQLException
    {
    	BUDAO dao = new BUDAO();
    	dao.updateBU(bu);
    }
}
