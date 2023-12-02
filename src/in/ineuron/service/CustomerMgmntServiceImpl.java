package in.ineuron.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.CustomerBO;
import in.ineuron.dao.ICustomerDAO;
import in.ineuron.dto.CustomerDTO;


@Service(value = "service")
public class CustomerMgmntServiceImpl implements ICustomerMgmntService {
	
	@Autowired
	private ICustomerDAO dao;
	
	static {
		System.out.println("CustomerMgmntServiceImpl .class file is being created...");
	}
	
	public CustomerMgmntServiceImpl() {
		System.out.println("CustomerMgmntServiceImpl:: Zero param constructor is being created...");
	}

	@Override
	public String calculateSimpleInterest(CustomerDTO dto) throws Exception {
		
		float intAmount = (dto.getPamt() * dto.getRate() * dto.getTime())/100.0f;
		
		CustomerBO customerBO = new CustomerBO();
		
		customerBO.setCustomerName(dto.getCustomerName());
		customerBO.setCustomerAddress(dto.getCustomerAddress());
		customerBO.setPamt(dto.getPamt());
		customerBO.setRate(dto.getRate());
		customerBO.setTime(dto.getTime());
		customerBO.setIntAmount(intAmount);
		
		int count = dao.save(customerBO);
		
		return count == 0 ? "Customer Registration Failed" : "Customer Registration Successful with an interest amt of :: " + intAmount;
	}

	@Override
	public String toString() {
		return "CustomerMgmntServiceImpl [dao=" + dao + "]";
	}
	
}
