package kr.ac.kopo.boxgo.Model;

public class Keywords {
	private int id;
	private String name;
	private int domainId;
	
	private String domainName;
	private String caption;

	public Keywords() {
		
	}
	
	public Keywords(int id, int domainId) {
		
		this.id = id;
		this.domainId = domainId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDomainId() {
		return domainId;
	}
	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	
}
