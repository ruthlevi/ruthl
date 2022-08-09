package app.core.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/fallback/serviceA")
	public String fallbackA() {
		return "Gateway fallback: cannot call Service A";
	}
	
	@GetMapping("/fallback/serviceB")
	public String fallbackB() {
		return "Gateway fallback: cannot call Service B";
	}
}
