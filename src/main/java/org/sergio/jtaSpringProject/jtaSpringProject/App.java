package org.sergio.jtaSpringProject.jtaSpringProject;

import org.sergio.jtaSpringProject.entities.Animal;
import org.sergio.jtaSpringProject.entities.Person;
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
        System.out.println( "Hello World!" );
        System.out.println("---------------");
        //test1();
        test2();
    }

    /*Acceso a servicios sin transacciones*/
	private static void test1() {
		//Obtenemos contexto de aplicacion utilizando Spring a traves del fichero de configuracion de Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AppService personService = (AppService) context.getBean("appService");
		
		Person person1 = new Person();
		person1.setFirstName("Sergio");
		person1.setLastName("Rodriguez");
		
		Animal animal1 = new Animal();
		animal1.setName("Tiger");
		
		personService.createPersonAndAnimal(person1, animal1);
		
		System.out.println("Test1 completado con exito");
	}
	
	/*Acceso a servicios sin transacciones*/
	private static void test2() {
		//Obtenemos contexto de aplicacion utilizando Spring a traves del fichero de configuracion de Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		AppService personService = (AppService) context.getBean("appService");
		
		Person person1 = new Person();
		person1.setFirstName("Sergio");
		person1.setLastName("Rodriguez");
		
		Animal animal1 = new Animal();
		//Debe fallar por sobre pasar los caracteres del campo nombre, establecido en 255
		animal1.setName("asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd");
		
		personService.createPersonAndAnimal(person1, animal1);
		
		System.out.println("Test2 completado con exito");
	}
	
	
}
