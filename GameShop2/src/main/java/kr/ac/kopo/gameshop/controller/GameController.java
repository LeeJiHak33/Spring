package kr.ac.kopo.gameshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

@Controller
@RequestMapping("/game")
public class GameController {

	final String path = "game/";
	final String uploadPath = "d://upload/";

	@Autowired
	GameService service; // 실질적인 비지니스로직 실행하는 인터페이스

	@Autowired
	PublisherService publisherService;

	@ResponseBody
	@RequestMapping("/delete_attach/{id}")
	public String deleteAttach(@PathVariable int id) {
		if(service.deleteAttach(id)) {
			return "OK";
		}else {
			return "FAIL";
		}
	}
	
	// game/list로 uri 처리
	@RequestMapping("/list")
	public String list(Model model, Pager pager) {
		List<Game> list = service.list(pager);// 여기에 게임 목록담김

		model.addAttribute("list", list); // jsp에 넘겨줌

		return path + "list";// viewResolver에게 넘겨줌
	}

	@GetMapping("/add")
	public String add(Model model) {
		Pager pager = new Pager();
		List<Publisher> list = publisherService.list(pager);
		model.addAttribute("list", list);
		return path + "add";
	}

	@PostMapping("/add") // 주소가 add인경우에 post로 오면 내가 처리하겠다.
	public String add(Game item, @SessionAttribute Member member) {// 데이터를 게임객체로 받는다 // 로그인했는지 안했는지 정보는 session에있음

		item.setMemberId(member.getId()); // item에 memberid 넣어주기

		try {
			List<Attach> list = new ArrayList<Attach>(); // 목록
			for (MultipartFile attach : item.getAttach()) {//몇개있는지 신경 쓸필요가 없음

				if (attach != null && !attach.isEmpty()) {
					String filename = attach.getOriginalFilename();

					attach.transferTo(new File(uploadPath + filename));

					Attach attachItem = new Attach(); // 이미지 객체
					attachItem.setFilename(filename);// 이미지 넣기

					list.add(attachItem); // 리스트에다가 이미지 객체 넣기

				}

			}

			item.setAttachs(list); // 게임 객체에 이미지 리스트 넣기

			service.add(item);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "redirect:list";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @SessionAttribute Member member) {// 주소 줄에 있는 id 값를 가져와서 넣어줘라

		service.delete(id, member.getId());

		return "redirect:../list";
	}

	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @SessionAttribute Member member) {// session이 없으면 접근 불가하게 만듬
		Game item = service.item(id);// db에서 가져온 값을 game 객체에 넣어준다

		if (member.getId().equals(item.getMemberId())) {
			model.addAttribute("item", item);

			Pager pager = new Pager();

			List<Publisher> list = publisherService.list(pager);

			model.addAttribute("list", list);

			return path + "update";
		} else {
			return "redirect:../list";
		}

	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, Game item, @SessionAttribute Member member) {
		item.setMemberId(member.getId());
		item.setId(id);// 클릭할 떄 받은 id를 item에 넣어준다.
		
		try {
			List<Attach> list = new ArrayList<Attach>(); // 목록
			for (MultipartFile attach : item.getAttach()) {//몇개있는지 신경 쓸필요가 없음

				if (attach != null && !attach.isEmpty()) {
					String filename = attach.getOriginalFilename();

					attach.transferTo(new File(uploadPath + filename));

					Attach attachItem = new Attach(); // 이미지 객체
					attachItem.setFilename(filename);// 이미지 넣기

					list.add(attachItem); // 리스트에다가 이미지 객체 넣기

				}

			}

			item.setAttachs(list); // 게임 객체에 이미지 리스트 넣기

			service.update(item);
		} catch (Exception e) {
			// TODO: handle exception
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

	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		Game item = service.item(id);
		model.addAttribute("item", item);

		return path + "detail";
	}

}
