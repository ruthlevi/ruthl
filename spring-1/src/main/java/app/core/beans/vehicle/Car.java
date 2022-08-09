package app.core.beans.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@Primary
public class Car implements Vehicle {

	//DI - Dependency Injection
//	@Autowired
	@Qualifier("basicCarEngine")
	private Engine engine;
	private int maxSpeed;
	
	@Autowired
	public Car(Engine engine, @Value("${car.max.speed}") int maxSpeed) {
		super();
		this.engine = engine;
		this.maxSpeed = maxSpeed;
	}
	
	
	public int getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}


	@Override
	public void move() {
		engine.start();
		System.out.println("Car is moving");
	}

	@Override
	public void stop() {
		engine.stop();
		System.out.println("Car stopped");
	}

	

}
