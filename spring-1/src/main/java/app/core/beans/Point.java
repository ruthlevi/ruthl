package app.core.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
//@Component("the-point")
//@Lazy - one we configure this bean as prototype it must be Lay
//@Scope("prototype")
public class Point {
	
	{ //initializer
		System.out.println("Point created");
	}
	
	private int x;
	private int y;

}
