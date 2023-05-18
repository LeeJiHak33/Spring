package kr.ac.kopo.gameshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.pager.Pager;
import kr.ac.kopo.gameshop.service.GameService;

@RestController
@RequestMapping("/api/game")
public class GameRestController {
	@Autowired
	GameService service;
	

	@GetMapping
	public List<Game> list(Pager pager){
		return service.list(pager);
	}
	@PostMapping
	public Game add(@RequestBody Game item) {
		service.add(item);
		return item;
	}
	@PutMapping
	public Game update(@RequestBody Game item) {
		service.update(item);
		
		return item;
	}
	
	@DeleteMapping
	public Game delete(@RequestBody Game item ) {
		service.delete(item.getId(), item.getMemberId());
		return item;
	}
}
