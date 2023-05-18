package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.model.Customer;
import kr.ac.kopo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	final String path = "customer/";
	
	@Autowired
	CustomerService service;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Customer> list = service.list();
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Customer item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update")
	public String update(int custid, Model model) {
		Customer item = service.item(custid);
		
		model.addAttribute("item", item);
		
		return path + "update";		
	}
	
	@PostMapping("/update")
	public String update(Customer item) {
		service.update(item);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(int custid) {
		service.delete(custid);
		
		return "redirect:list";
	}
}
