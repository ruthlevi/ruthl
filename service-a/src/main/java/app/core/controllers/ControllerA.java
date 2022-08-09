package app.core.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ControllerA {

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "handleAFallback")
	@GetMapping("/service/a")	
	public String handleA() {
		String serviceId = "service-b";
//		URI baseUri = getServiceInstanceBaseUri(serviceId);
		String url = "http://service-b/service/b";
		System.out.println(url);
		String response = restTemplate.getForObject(url, String.class);
		return "Service A calling B: " + response;
	}
	
	private String handleAFallback(Throwable t) {
		return "Service A fallback: cant reach service B. cause: " + t.getMessage();
	}
	
//	private URI getServiceInstanceBaseUri(String serviceId) {
//		ServiceInstance instance = loadBalancer.choose(serviceId);
////		List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
////		return instances.get(0).getUri();
//		return instance.getUri();
//	}
}
