package kr.ac.kopo.boxgo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.boxgo.Model.Domain;
import kr.ac.kopo.boxgo.Service.DomainService;
import kr.ac.kopo.boxgo.pager.Pager;

@Controller
@RequestMapping("/domain")
public class DomainController {
	final String path="domain/";
	
	@Autowired
	DomainService service;
	
	@GetMapping("/list")
	public String list(Model model, Pager pager) {
		List<Domain> list=service.list(pager);
		
		model.addAttribute("list", list);
		
		return path+"list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path+"add";
	}
	
	@PostMapping("/add")
	public String add(Domain item){
		service.add(item);
		return "redirect:list";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		
		return "redirect:../list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		Domain item=service.item(id);
		model.addAttribute("item", item);
		return path+"update";
	}
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, Domain item) {
		item.setId(id);
		
		service.update(item);
		
		return "redirect:../list";
		
	}
}
