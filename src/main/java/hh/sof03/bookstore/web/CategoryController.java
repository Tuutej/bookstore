package hh.sof03.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

	
	@Autowired
	private CategoryRepository categoryRepo;

	// list categories in database
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String categoryList(Model model) {
		List<Category> categories = (List<Category>) categoryRepo.findAll();
		model.addAttribute("categories", categories);
		
		return "categorylist";
	}
	
	// add a new category to database
	
	@RequestMapping(value = "/addcategory")
	public String addcategory(Model model) {
		model.addAttribute("category", new Category());
		
		return "addcategory";
	}
			
	// save a new category entry into the database
			
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String savecategory(Category category) {
		categoryRepo.save(category);
		
		return "redirect:categorylist";
	}
			
}
