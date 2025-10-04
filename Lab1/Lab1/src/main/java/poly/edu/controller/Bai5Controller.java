package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bai5Controller {

	@GetMapping("/bai5/form")
	public String form() {
		return "bai5";
	}

	@PostMapping("/bai5/check")
	public String tinh(@RequestParam("chieudai") String chieudai, @RequestParam("chieurong") String chieurong,
			Model model) {
		double d = Double.valueOf(chieudai);
		double r = Double.valueOf(chieurong);
		double S = d * r;
		double C = (d + r) * 2;
		model.addAttribute("chuvi", C);
		model.addAttribute("dientich", S);
		return "ketqua";
	}
}
