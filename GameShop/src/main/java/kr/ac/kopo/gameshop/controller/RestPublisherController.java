package kr.ac.kopo.gameshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.model.Publisher;
import kr.ac.kopo.gameshop.pager.Pager;
import kr.ac.kopo.gameshop.service.PublisherService;

@RestController
@RequestMapping("/api/publisher")
public class RestPublisherController {
	@Autowired
	PublisherService service;
	
	@GetMapping
	public List<Publisher> list(Pager pager){
		return service.list(pager);
	}
	@PostMapping
	public Publisher add(@RequestBody Publisher item) {
		service.add(item);
		return item;
	}
	@PutMapping
	public Publisher update(@RequestBody Publisher item) {
		service.update(item);
		
		return item;
	}
	
	@DeleteMapping
	public Publisher delete(@RequestBody Publisher item ) {
		service.delete(item.getId());
		return item;
	}
}
