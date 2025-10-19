package poly.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.entity.Report;
import poly.edu.repository.ProductDAO;

@Controller
public class ReportController {
	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/report/inventory-by-category")
	public String inventory(Model model) {
		List<Report> items = productDAO.getInventoryByCategory();
		model.addAttribute("items", items);
		return "report/inventoryByCategory";
	}
}
