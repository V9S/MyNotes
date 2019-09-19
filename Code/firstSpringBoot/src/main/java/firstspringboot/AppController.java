package firstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZLM
 * @date 2019/09/16
 */
@RestController
public class AppController {

	@GetMapping("/")
	public String hello() {
		return "Hello SpringBoot";
	}
}