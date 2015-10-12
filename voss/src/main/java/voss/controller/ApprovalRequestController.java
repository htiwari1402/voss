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
import voss.dao.RequestDAO;
import voss.dao.userRegDao;
import voss.domain.Designation;
import voss.domain.ProductMaster;
import voss.domain.Request;
import voss.domain.UserEntity;
import voss.entity.BankMasterEntity;
import voss.entity.BusinessUnitEntity;
import voss.repository.BankMasterRepository;
import voss.repository.BusinessUnitRepository;


@Controller
public class ApprovalRequestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private ApplicationContext appContext;
    
    @RequestMapping("/getAllRequests")
    @ResponseBody
    public List<Request> getAllRequests(HttpSession session)
    {
		RequestDAO dao = new RequestDAO();
		return dao.getAllRequests((int)session.getAttribute("userId"));
    }
    @RequestMapping("/approveRequest")
    @ResponseBody
    public void approveRequest(HttpSession session,@RequestParam(value="requestID", defaultValue="0") int requestID)
    {
		RequestDAO dao = new RequestDAO();
		dao.approveRequest(requestID);
    }
    @RequestMapping("/rejectRequest")
    @ResponseBody
    public void rejectRequest(HttpSession session,@RequestParam(value="requestID", defaultValue="0") int requestID)
    {
		RequestDAO dao = new RequestDAO();
		dao.rejectRequest(requestID);
    }
    @RequestMapping("/createRequest")
    @ResponseBody
    public void rejectRequest(HttpSession session,@RequestBody Request request)
    {
		RequestDAO dao = new RequestDAO();
		dao.createRequest(request);
    }

}
