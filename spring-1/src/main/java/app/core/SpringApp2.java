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
public class SpringApp2 {

	public static void main(String[] args) {
		//ARM - Auto Resource Management (try with resources) - working with Closeable objects
		try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringApp2.class);){
			
			Shape shape = context.getBean(Shape.class);
			System.out.println(shape);
			
			Car vehicle = context.getBean(Car.class);
			vehicle.move();
			vehicle.stop();
			System.out.println("car speed: " + vehicle.getMaxSpeed());
			
			Car turboCar = context.getBean("turboCar", Car.class);
			turboCar.move();
			turboCar.stop();
			System.out.println("turboCar speed: " + turboCar.getMaxSpeed());

		}
		

	}
	
	@Bean
	public Car turboCar( @Value("${car.max.speed.turbo}") int maxSpeed) {
		Car car = new Car(new TurboEngine(), maxSpeed);
		return car;
	}

}
