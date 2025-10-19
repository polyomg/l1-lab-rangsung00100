package poly.edu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.edu.entity.Product;
import poly.edu.repository.ProductDAO;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/product/sort")
	public String sort(Model model, @RequestParam(value = "field", required = false) String field) {
		Sort sort = (field != null) ? Sort.by(Direction.DESC, field) : Sort.unsorted();
		model.addAttribute("field", (field != null) ? field.toUpperCase() : "ALL");

		List<Product> items = (field != null) ? productDAO.findAll(sort) : productDAO.findAll();
		model.addAttribute("items", items);

		return "product/sort";
	}

	@RequestMapping("/product/page")
	public String paginate(Model model, @RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> page = productDAO.findAll(pageable);
		model.addAttribute("page", page);
		return "product/page";
	}

}
