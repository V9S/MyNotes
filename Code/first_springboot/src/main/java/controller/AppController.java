package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("/HelloSpringBoot")
	public String Hello() {
		return "Hello SpringBoot";
	}
}
