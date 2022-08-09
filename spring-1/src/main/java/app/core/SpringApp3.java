package app.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import app.core.beans.Shape;
import app.core.beans.vehicle.Car;
import app.core.beans.vehicle.TurboEngine;
import app.core.beans.vehicle.Vehicle;

@ComponentScan
@Configuration
@PropertySource("application.properties")
public class SpringApp3 {

	public static void main(String[] args) throws InterruptedException {
		//ARM - Auto Resource Management (try with resources) - working with Closeable objects
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApp3.class);){
			String[] beans = context.getBeanDefinitionNames();
			for(String name : beans) {
				System.out.println(name);
			}
			Thread.sleep(3000);

		}
		

	}
	


}
