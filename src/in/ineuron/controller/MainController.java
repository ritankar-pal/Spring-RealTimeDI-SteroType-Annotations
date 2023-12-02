package in.ineuron.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import in.ineuron.dto.CustomerDTO;
import in.ineuron.service.ICustomerMgmntService;
import in.ineuron.vo.CustomerVO;


@Controller(value = "controller")
public class MainController {
	
	@Autowired
	private ICustomerMgmntService service;
	
	static {
		System.out.println("MainController.class file is being created...");
	}
	
	public MainController() {
		System.out.println("MainController:: Zero param constructor is being created...");
	}
	
	
	public String processCustomer(CustomerVO vo) throws Exception {
		
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setCustomerName(vo.getCustomerName());
		customerDTO.setCustomerAddress(vo.getCustomerAddress());
		customerDTO.setPamt(Float.parseFloat(vo.getPamt()));
		customerDTO.setRate(Float.parseFloat(vo.getRate()));
		customerDTO.setTime(Float.parseFloat(vo.getTime()));
		
		String result = service.calculateSimpleInterest(customerDTO);
		
		return result;
	}

	@Override
	public String toString() {
		return "MainController [service=" + service + "]";
	}
	
	
}
