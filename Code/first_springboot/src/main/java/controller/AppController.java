package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/controller")
@RestController
public class AppController {

	@GetMapping("/hello")
	public String Hello() {
		return "Hello SpringBoot";
	}
}
