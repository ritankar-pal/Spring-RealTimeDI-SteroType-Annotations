package in.ineuron.test;
import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ineuron.controller.MainController;
import in.ineuron.vo.CustomerVO;



public class TestApp {

	public static void main(String[] args) throws Exception {
		
		//Reading the inputs::
		Scanner scan = new Scanner(System.in);
			
		System.out.print("Enter the Customer Name:: ");
		String customerName = scan.next();
		
		System.out.print("Enter the Customer Address:: ");
		String customerAddress = scan.next();
		
		System.out.print("Enter the Principal Amount:: ");
		String pamt = scan.next();
		
		System.out.print("Enter the Rate of Interest:: ");
		String rate = scan.next();
		
		System.out.print("Enter the Time:: ");
		String time = scan.next();
		
		//Making an object of CustomerVO and setting the inputs::
		CustomerVO customerVO = new CustomerVO();
		customerVO.setCustomerName(customerName);
		customerVO.setCustomerAddress(customerAddress);
		customerVO.setPamt(pamt);
		customerVO.setRate(rate);
		customerVO.setTime(time);
	
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("in/ineuron/cfg/applicationContext.xml");
		MainController controller = factory.getBean("controller",MainController.class); //Created an Object of MainController
		System.out.println("\n***********Container Started*************\n");
		
		try {
			String result = controller.processCustomer(customerVO);
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println("Internal Problem...Please Try Again!");
		}
		
		factory.close();
		scan.close();
		System.out.println("\n***********Container Stopper*************");
		
	}

}
