//package org.sergio.jtaSpringProject.jtaSpringProject;
//
//import org.sergio.jtaSpringProject.entities.Animal;
//import org.sergio.jtaSpringProject.entities.Person;
//import org.sergio.jtaSpringProject.services.AnimalService;
//import org.sergio.jtaSpringProject.services.AppService;
//import org.sergio.jtaSpringProject.services.PersonService;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
///**
// * Unit test for simple App.
// */
//public class AppTest 
//    extends TestCase
//{
//    /**
//     * Create the test case
//     *
//     * @param testName name of the test case
//     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }
//
//    /**
//     * @return the suite of tests being tested
//     */
//    public static Test suite()
//    {
//        return new TestSuite( AppTest.class );
//    }
//
//    /**
//     * Rigourous Test :-)
//     */
//    public void testApp()
//    {
//    	//CommitTest
//    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		AppService appService = (AppService) context.getBean("appService");
//		
//		Person person1 = new Person();
//		person1.setFirstName("Sergio");
//		person1.setLastName("Rodriguez");
//		
//		Animal animal1 = new Animal();
//		animal1.setName("Tiger");
//		
////		appService.createPersonAndAnimal(person1, animal1);
//		
//		PersonService personService = (PersonService) context.getBean("personService");
//		AnimalService animalService = (AnimalService) context.getBean("animalService");
//		
//		Long person1Id = person1.getId();
//		Long animal1Id = animal1.getId();
//		
//		Person personCheck = personService.getPerson(person1Id);
//		Animal animalCheck = animalService.getAnimal(animal1Id);
//		
//        assertTrue( personCheck != null && person1.equals(personCheck) );
//        assertTrue(animalCheck != null && animal1.equals(animalCheck));
//        
//        //Rollback
//        
//        Person person2 = new Person();
//		person2.setFirstName("Sergio2");
//		person2.setLastName("Rodriguez2");
//		
//		Animal animal2 = new Animal();
//		animal2.setName("Tiger2");
//		
////		appService.createPersonAndAnimal(person2, animal2);
//		
//		Person personCheck2 = personService.getPerson(person2.getId());
//		Animal animalCheck2 = animalService.getAnimal(animal2.getId());
//		
//        assertTrue( personCheck == null);
//        assertTrue( animalCheck == null);
//        
//    }
//}
