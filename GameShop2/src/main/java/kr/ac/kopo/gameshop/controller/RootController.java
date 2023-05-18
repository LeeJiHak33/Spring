package kr.ac.kopo.gameshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.gameshop.model.Game;
import kr.ac.kopo.gameshop.model.Member;
import kr.ac.kopo.gameshop.service.GameService;
import kr.ac.kopo.gameshop.service.MemberService;


@Controller
public class RootController {
	
	@Autowired
	MemberService service;
	
	@Autowired
	GameService gameService;
	
	@RequestMapping("/") //처리할 주소
	public String index(Model model) {
		Game item = gameService.item(206);
		model.addAttribute("item", item);
		return"index";//index.jsp파일을 사용자에게 보여주겠다.
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		if (service.login(member)) {
			session.setAttribute("member", member);//멤버의 정보를 세션에 넣음
			
			String targetUrl =(String) session.getAttribute("target_url");
			session.removeAttribute("target_url");
			
			if(targetUrl == null) {
				return "redirect:.";
			}
			else {
				return "redirect:"+targetUrl;
			}
			
			
		}
		else {
			return "redirect:login";
		}
		
	}
	
	@GetMapping("/signup")
	public String signup() {
		System.out.println("...");
		return"signup";
	}
	@PostMapping("/signup")
	public String signup(Member item) {
		System.out.println(item.getId());
		service.signup(item);
		return "redirect:.";
	}
	
	@ResponseBody
	@GetMapping("checkId/{id}")
	public String checkId( @PathVariable String id) {
		if(service.checkId(id)) {
			return "OK";
		}
		else {
			return "FAIL";
		}
		
	}
	
	@RequestMapping
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:.";
	}
	
}
