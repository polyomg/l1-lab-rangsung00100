package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OkController {
	@RequestMapping("/ok")
	public String ok() {
		System.out.println("aa");
		return "ok";
	}

	@PostMapping("/ok")
	public String m1(Model model) {
		model.addAttribute("name", "m1()");
		return "ok";
	}

	@GetMapping("/okk")
	public String m2(Model model) {
		model.addAttribute("name", "m2()");
		return "ok";
	}

	@PostMapping("/ctrl/ok")
	public String m3(Model model, @RequestParam("x") String x) {
		model.addAttribute("name", "m3()");
		return "ok";
	}
}
