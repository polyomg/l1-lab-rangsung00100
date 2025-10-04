package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
	@Autowired
	HttpServletRequest request;

	@GetMapping("/login/form")
	public String form() {
		return "login";
	}

	@PostMapping("/login/check")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		if ("poly".equals(username) && "123".equals(password)) {
			return "redirect:/login/form?success=true";
		}
		// Trường hợp đăng nhập thất bại
		model.addAttribute("message", "Tài khoản hoặc mật khẩu không đúng!");
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		return "login";
	}
}
