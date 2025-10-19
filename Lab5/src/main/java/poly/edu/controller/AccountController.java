package poly.edu.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import poly.edu.entity.User;
import poly.edu.service.CookieService;
import poly.edu.service.ParamService;
import poly.edu.service.SessionService;

@Controller
public class AccountController {
	@Autowired
	CookieService cookieService;
	@Autowired
	ParamService paramService;
	@Autowired
	SessionService sessionService;

	@GetMapping("/account/login")
	public String login1(Model model) {
		model.addAttribute("user", cookieService.getValue("user"));
		model.addAttribute("password", cookieService.getValue("password"));
		return "account/login";
	}

	@PostMapping("/account/login")
	public String login2(Model model) {
		String un = paramService.getString("username", "");
		String pw = paramService.getString("password", "");
		boolean rm = paramService.getBoolean("remember", false);

		if ("poly".equals(un) && "123".equals(pw)) {
			sessionService.set("username", un);
			if (rm) {
				cookieService.add("user", un, 10 * 24);
				cookieService.add("password", pw, 10 * 24);
			} else {
				cookieService.remove("user");
				cookieService.remove("password");
			}
//			return "redirect:/home"; // Điều hướng sau khi đăng nhập thành công
		} else {
			sessionService.remove("username");
			model.addAttribute("mess", "tài khoản hoặc mật khẩu không chính xác");
		}
		model.addAttribute("user", cookieService.getValue("user"));
		model.addAttribute("password", cookieService.getValue("password"));
		return "account/login";
	}

	@GetMapping("/account/register")
	public String registerForm() {
		return "/account/register";
	}

	@PostMapping("/account/register")
	public String register(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("profileImage") MultipartFile file, Model model) {
		try {
			List<User> list = sessionService.get("list");
			if (list == null) {
				list = new ArrayList<User>();
			}
			String uploadDir = new File("src/main/resources/static/images/").getAbsolutePath();
			Path uploadPath = Paths.get(uploadDir);
			if (!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			Path filePath = uploadPath.resolve(file.getOriginalFilename());
			Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
			list.add(new User(username, password, file.getOriginalFilename()));
			model.addAttribute("messSucces", "tạo tài khoản thành công");
			sessionService.set("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/account/register";
	}

	@GetMapping("/account/login2")
	public String login3() {
		return "/account/login2";
	}

	@PostMapping("/account/login2")
	public String login4(Model model) {
		String un = paramService.getString("username", "");
		String pw = paramService.getString("password", "");
		List<User> list = sessionService.get("list");
		if (list == null) {
			list = new ArrayList<User>();
		}
		list.forEach(x -> {
			if (x.getName().equals(un) && x.getPassword().equals(pw)) {
				sessionService.set("account", x);
				return;
			}
		});
		if (sessionService.get("account") != null) {
			return "account/index";
		}
		model.addAttribute("mess", "tài khoản hoặc mật khẩu không chính xác");
		return "account/login2";
	}
}
