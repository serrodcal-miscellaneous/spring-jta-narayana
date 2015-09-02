package org.sergio.jtaSpringProject;

import java.util.LinkedList;
import java.util.List;

import org.sergio.jtaSpringProject.entities.Client;
import org.sergio.jtaSpringProject.entities.Transfer;
import org.sergio.jtaSpringProject.services.AppService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
		if(logger.isDebugEnabled()){
			logger.debug("Init POC");
		}
        System.out.println( "Test Execution" );
        System.out.println("---------------");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        if(context != null){
        	if(logger.isDebugEnabled()){
    			logger.debug("Get context");
    		}
	        test1(context);
	        test2(context);
        }else{
        	logger.error("Cannot get context");
        }
        
        System.out.println("---------------");
        System.out.println( "End Test Execution" );
        if(logger.isDebugEnabled()){
			logger.debug("EndPoc");
		}
    }

    /*Acceso a servicios sin transacciones*/
	private static void test1(ApplicationContext context) {
		if(logger.isDebugEnabled()){
			logger.debug("Init Test 1");
		}
		System.out.println("Begin Test 1");
		
		AppService appService = (AppService) context.getBean("appService");
		
		if(appService != null){
			
			if(logger.isDebugEnabled()){
				logger.debug("Get AppService");
			}
			
			Client originClient = new Client();
			originClient.setName("John Doe");
			originClient.setBalance(100.00);
			
			Client targetClient = new Client();
			targetClient.setName("Alice Doe");
			targetClient.setBalance(1000.00);
			
			Transfer transfer1 = new Transfer();
			transfer1.setConcept("Flat water bill");
			transfer1.setAmount(30.00);
			List<Client> clients = new LinkedList<Client>();
			clients.add(originClient);
			clients.add(targetClient);
			transfer1.setClients(clients);
			
			try{
				appService.makeTransfer(transfer1);
				if(logger.isDebugEnabled()){
					logger.debug("Transfer Success");
				}
			}catch (Exception e){
				logger.error("Transference error");
			}
		}else{
			logger.error("Cannot inject AppService");
		}
		
		System.out.println("End Test 1");
		if(logger.isDebugEnabled()){
			logger.debug("End Test 1");
		}
	}
	
	/*Acceso a servicios sin transacciones*/
	private static void test2(ApplicationContext context) {
		if(logger.isDebugEnabled()){
			logger.debug("Begin Test 2");
		}
		
		AppService appService = (AppService) context.getBean("appService");
		
		Client originClient = new Client();
		originClient.setName("John Doe");
		originClient.setBalance(100.00);
		
		Client targetClient = new Client();
		targetClient.setName("Alice Doe");
		targetClient.setBalance(1000.00);
		
		Transfer transfer1 = new Transfer();
		transfer1.setConcept("Flat water bill");
		transfer1.setAmount(10000.00);
		List<Client> clients = new LinkedList<Client>();
		clients.add(originClient);
		clients.add(targetClient);
		transfer1.setClients(clients);
		
		try{
			appService.makeTransfer(transfer1);
			if(logger.isDebugEnabled()){
				logger.debug("Transfer Success");
			}
		}catch (Exception e){
			logger.error("Transference error");
		}
		
		System.out.println("End Test 2");
		if(logger.isDebugEnabled()){
			logger.debug("End Test 2");
		}
	}
	
	
}
