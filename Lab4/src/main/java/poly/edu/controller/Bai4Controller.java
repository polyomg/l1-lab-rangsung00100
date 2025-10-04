package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bai4Controller {
	@GetMapping("/home/index")
	public String detail(Model model) {
		return "bai4/home";
	}
	@GetMapping("/home/about")
	public String about(Model model) {
		return "bai4/about";
	}
}
