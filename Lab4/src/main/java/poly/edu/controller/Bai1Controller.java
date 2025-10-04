package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import poly.edu.entity.Staff;

@Controller
public class Bai1Controller {
	@GetMapping("/staff/create/form")
	public String detail(Staff staff, Model model) {
		model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
		return "bai1/staff";
	}

	@PostMapping("/staff/create/save")
	public String createSave(Model model, Staff staff, @RequestPart("photo_file") MultipartFile photoFile) {
		if (!photoFile.isEmpty()) {
			staff.setPhoto(photoFile.getName());
		}
		model.addAttribute("message", "Xin chào " + staff.getFullname());
		return "bai1/staff";
	}
}
