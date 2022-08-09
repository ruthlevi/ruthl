package app.core.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class Rectangle implements Shape{

	private int length;
	private int width;
	
	@Override
	public double getArea() {
		return length * width;
	}
}
