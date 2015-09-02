package org.sergio.jtaSpringProject;

import org.sergio.jtaSpringProject.entities.Animal;
import org.sergio.jtaSpringProject.entities.Client;
import org.sergio.jtaSpringProject.entities.Person;
import org.sergio.jtaSpringProject.entities.Transfer;
import org.sergio.jtaSpringProject.services.AppService;
import org.sergio.jtaSpringProject.services.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Test Execution" );
        System.out.println("---------------");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        test1(context);
        test2(context);
        
        System.out.println("---------------");
        System.out.println( "End Test Execution" );
    }

    /*Acceso a servicios sin transacciones*/
	private static void test1(ApplicationContext context) {
		System.out.println("Begin Test 1");
		
		AppService appService = (AppService) context.getBean("appService");
		
		Client originClient = new Client();
		originClient.setName("John Doe");
		originClient.setBalance(100.00);
		
		Client targetClient = new Client();
		targetClient.setName("Alice Doe");
		targetClient.setBalance(1000.00);
		
		appService.createClient(originClient);
		appService.createClient(targetClient);
		
		Transfer transfer1 = new Transfer();
		transfer1.setConcept("Flat water bill");
		transfer1.setAmount(30.00);
		transfer1.setOriginClient(originClient);
		transfer1.setTargetClient(targetClient);
		
		try{
			appService.makeTransfer(transfer1);
			System.out.println("Test 1 Success");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println("End Test 1");
	}
	
	/*Acceso a servicios sin transacciones*/
	private static void test2(ApplicationContext context) {
		System.out.println("Begin Test 2");
		
		AppService appService = (AppService) context.getBean("appService");
		
		Client originClient = new Client();
		originClient.setName("John Doe");
		originClient.setBalance(100.00);
		
		Client targetClient = new Client();
		targetClient.setName("Alice Doe");
		targetClient.setBalance(1000.00);
		
		appService.createClient(originClient);
		appService.createClient(targetClient);
		
		Transfer transfer1 = new Transfer();
		transfer1.setConcept("Flat water bill");
		transfer1.setAmount(10000.00);
		transfer1.setOriginClient(originClient);
		transfer1.setTargetClient(targetClient);
		
		try{
			appService.makeTransfer(transfer1);
			System.out.println("Test 2 Success");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println("End Test 2");
	}
	
	
}
