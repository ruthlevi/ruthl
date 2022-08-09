package app.core;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.core.beans.Point;

public class SpringApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		System.out.println("up");
		
		Point p1 = context.getBean("the-point", Point.class);
		Point p2 = context.getBean("the-point", Point.class);
		p1.setX(100);
		System.out.println(p1);
		System.out.println(p2);
		
		Integer r1 = context.getBean(Integer.class);
		Integer r2 = context.getBean(Integer.class);
		Integer r3 = context.getBean(Integer.class);

		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		
		context.close();
		System.out.println("doun");

	}

}
