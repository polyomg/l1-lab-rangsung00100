package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bai5Controller {
	@GetMapping("/home/index2")
	public String detail(Model model) {
		return "bai5/home";
	}
	@GetMapping("/home/about2")
	public String about(Model model) {
		return "bai5/about";
	}
}
