package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.beans.Point;

//@ComponentScan
//@Configuration
public class Config {

	//add bean definitions here
	@Bean
	public Point point100() {
		Point p = new Point();
		p.setX(100);
		p.setY(100);
		return p;
	}
	
	@Bean
	@Scope("prototype")
	public Integer random() {
		return (int) (Math.random()*101);
	}
	
}
