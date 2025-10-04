package poly.edu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.entity.Product;

@Controller
public class ProductController {
	List<Product> list = new ArrayList<>(Arrays.asList(new Product("A", 1d), new Product("B", 12d)));
//	@GetMapping("/product/form")
//	public String form(Model model) {
//		 model.addAttribute("product", new Product());
//		return "bai3/form";
//	}
//
//	@PostMapping("/product/save")
//	public String save(Product product, Model model) {
//		System.out.println(product);
//		model.addAttribute("product", product);
//		return "bai3/form";
//	}

	@GetMapping("/product/form")
	public String form(Model model) {
		Product p = new Product();
		p.setName("iPhone 30");
		p.setPrice(5000.0);
		model.addAttribute("product", p);
		return "bai4/form";
	}

	@PostMapping("/product/save")
	public String save(Product p, Model model) {
		System.out.println(p);
		list.add(p);
		System.out.println("lõi");
		model.addAttribute("product", p);
		return "bai4/form";
	}

	@ModelAttribute("items")
	public List<Product> getItems() {
		return list;
	}
}
