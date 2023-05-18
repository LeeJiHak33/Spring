package kr.ac.kopo.gameshop.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.gameshop.model.Attach;
import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.model.Member;
import kr.ac.kopo.gameshop.model.Publisher;
import kr.ac.kopo.gameshop.pager.Pager;
import kr.ac.kopo.gameshop.service.GameService;
import kr.ac.kopo.gameshop.service.PublisherService;
import kr.ac.kopo.gameshop.service.WishService;

@Controller
@RequestMapping("/game")
public class GameController {
	final String path = "game/";
	final String uploadPath = "d://upload/";
	
	@Autowired
	GameService service;
	
	@Autowired
	PublisherService publisherService;	
	
	@Autowired
	WishService wishService;
	
	@ResponseBody
	@RequestMapping("/delete_attach/{id}")
	public String deleteAttach(@PathVariable int id) {
		if(service.deleteAttach(id))
			return "OK";
		
		return "FAIL";
	}
	
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		Game item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "detail";
	}

	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Game> list = service.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		Pager pager = new Pager();
		
		List<Publisher> list = publisherService.list(pager);
		
		model.addAttribute("list", list);
		
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Game item, @SessionAttribute Member member) {
		item.setMemberId( member.getId() );
		
		try {
			List<Attach> list = new ArrayList<Attach>();
			
			for(MultipartFile attach : item.getAttach()) {
				if(attach != null && !attach.isEmpty()) {
					String filename = attach.getOriginalFilename();
					
					attach.transferTo(new File(uploadPath + filename));					
						
					Attach attachItem = new Attach();
					attachItem.setFilename(filename);
	
					list.add(attachItem);
				}					
			}
				
			item.setAttachs(list);
			
			service.add(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:list";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @SessionAttribute Member member) {		
		service.delete(id, member.getId());
		
		return "redirect:../list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @SessionAttribute Member member) {
		Game item = service.item(id);
		
		if(member.getId().equals(item.getMemberId())) {
			model.addAttribute("item", item);
			
			Pager pager = new Pager();
			
			List<Publisher> list = publisherService.list(pager);
			
			model.addAttribute("list", list);
			
			return path + "update";
		} else		
			return "redirect:../list";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, Game item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());
		item.setId(id);
		
		try {
			List<Attach> list = new ArrayList<Attach>();
			
			for(MultipartFile attach : item.getAttach()) {
				if(attach != null && !attach.isEmpty()) {
					String filename = attach.getOriginalFilename();
					
					attach.transferTo(new File(uploadPath + filename));					
						
					Attach attachItem = new Attach();
					attachItem.setFilename(filename);
	
					list.add(attachItem);
				}					
			}
				
			item.setAttachs(list);
			
			service.update(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:../list";
	}
	
	@RequestMapping("/dummy")
	public String dummy(@SessionAttribute Member member) {
		service.dummy(member.getId());
		
		return "redirect:list";
	}
	
	@RequestMapping("/init")
	public String init() {
		service.init();
		
		return "redirect:list";
	}
	
	@ResponseBody
	@PutMapping("/wish/{id}")
	public String addWish(@PathVariable int id, @SessionAttribute Member member) {
		if(wishService.add(id,member.getId()))
			return "ok";
		return "fail";
	}
	
	@ResponseBody
	@DeleteMapping("/wish/{id}")
	public String deleteWish(@PathVariable int id, @SessionAttribute Member member) {
		if(wishService.delete(id,member.getId()))
			return "ok";
		return "fail";
	}
}
