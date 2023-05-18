package kr.ac.kopo.boxgo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.boxgo.Model.Keywords;
import kr.ac.kopo.boxgo.Service.KeywordsService;
import kr.ac.kopo.boxgo.pager.KeywordsPager;


@Controller
@RequestMapping("/keywords/{domainId}")
public class KeywordsController {
	final String path="keywords/";
	@Autowired
	KeywordsService service;
	
	@GetMapping("/list")
	public String list(@PathVariable int domainId, Model model,@ModelAttribute("pager") KeywordsPager pager) {//스프링은 type베이스이다.
		pager.setDomainId(domainId);
		List<Keywords> list=service.list(pager);
		model.addAttribute("list", list);
		return path+"list";
	}
	@GetMapping("/add")
	public String add() {
		return path+"add";
	}
	@PostMapping("/add")
	public String add(@PathVariable int domainId, Keywords item) {
		item.setDomainId(domainId);
		service.add(item);
		return "redirect:list";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int domainId, @PathVariable int id) {
		
		service.delete(new Keywords(id,domainId));
		return "redirect:../list";
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable int domainId, @PathVariable int id,Model model) {
		Keywords item=service.item(new Keywords(id, domainId));
		model.addAttribute("item", item);
		return path+"update";
	}
	@PostMapping("/update/{id}")
	public String update(@PathVariable int domain, @PathVariable int id,Keywords item) {
		item.setId(id);
		item.setDomainId(domain);
		service.update(item);
		return "redirect:../list";
	}
	
}
