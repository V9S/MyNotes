package firstspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZLM
 * @date 2019/09/16
 */
@RestController
public class AppController {

    
	@GetMapping("/hello")
	public String hello() {
	    System.out.println("1111111111111");
		return "Hello SpringBoot";
	}
}