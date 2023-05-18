package kr.ac.kopo;



import java.io.File;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RootController {
	final String path = "d://upload/";
	
	ArrayList<Image> list;
	
	public RootController() {
		list =new ArrayList<Image>();
		
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",list);
		return "index";
	}
	
	@PostMapping("/upload")
	public String upload(Image item) {
		MultipartFile file=item.getUploadFile(); //내가 올린 파일 어딘가에 저장된상태
		
		if(file !=null && file.getSize()>0) {
			String filename =file.getOriginalFilename();
			try {
				file.transferTo(new File(path+filename)); //내가 업로드한 파일 이름으로 파일 만들기
				item.setFilename(filename);
				list.add(item);//파일이 업로드 될때 마다 리스트에 저장
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
		return "redirect:.";
	}
	@ResponseBody
	@PostMapping("/upload_ajax")
	public String upload_ajax(Image item) {
		upload(item);
		
		return item.getFilename();
	}
}
