/**
 * 
 */
package kr.ac.kopo.gameshop.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Student
 *
 */
//(바구니)게임목록을 담는 곳
public class Game {
	private int id;
	private String title;
	private int publisherId;
	private int price;
	private Date regDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") //날짜 타입 지정
	private Date pubDate;
	private String memberId;
	
	private String name;
	private String publisher;
	private String contents;
	
	private List<MultipartFile> attach;
	private List<Attach> attachs;
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPubDateFormat() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //포맷 객체 생성
		
		return sdf.format(pubDate);//이거 포매팅 해줘
	}
	
	
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	

	public List<MultipartFile> getAttach() {
		return attach;
	}

	public void setAttach(List<MultipartFile> attach) {
		this.attach = attach;
	}

	public List<Attach> getAttachs() {
		return attachs;
	}

	public void setAttachs(List<Attach> attachs) {
		this.attachs = attachs;
	}


	
}
