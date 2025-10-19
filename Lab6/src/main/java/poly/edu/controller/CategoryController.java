package poly.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import poly.edu.entity.Category;
import poly.edu.repository.CategoryDAO;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO categoryDAO;

	@GetMapping("/category/index")
	public String index(Model model) {
		Category item = new Category();
		model.addAttribute("item", item);
		List<Category> items = categoryDAO.findAll();
		model.addAttribute("items", items);
		return "category/index";
	}

	@GetMapping("/category/edit/{id}")
	public String edit(Model model, @PathVariable("id") String id) {
		Category item = categoryDAO.findById(id).get();
		model.addAttribute("item", item);
		List<Category> items = categoryDAO.findAll();
		model.addAttribute("items", items);
		return "category/index";
	}

	@GetMapping("/category/create")
	public String create(Category item) {
		categoryDAO.save(item);
		return "redirect:/category/index";
	}

	@GetMapping("/category/update")
	public String update(Category item) {
		categoryDAO.save(item);
		return "redirect:/category/edit/" + item.getId();
	}

	@GetMapping("/category/delete/{id}")
	public String create(@PathVariable("id") String id) {
		categoryDAO.deleteById(id);
		return "redirect:/category/index";
	}

}
