package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import kr.ac.kopo.model.Book;
import kr.ac.kopo.pager.Pager;
import kr.ac.kopo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	final String path = "book/";
	
	@Autowired
	BookService service;
	
	@RequestMapping("/dummy")
	public String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	@RequestMapping("/init")
	public String init() {
		service.init();
		
		return "redirect:list";
	}

	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Book> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	// @RequestMapping(value="/add", method=RequestMethod.GET)
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	// @RequestMapping(value="/add", method=RequestMethod.POST)
	@PostMapping("/add")
	public String add(Book item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update")
	public String update(int bookid, Model model) {
		Book item = service.item(bookid);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update")
	public String update(Book item) {
		service.update(item);
		
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(int bookid) {
		service.delete(bookid);
		
		return "redirect:list";
	}
}