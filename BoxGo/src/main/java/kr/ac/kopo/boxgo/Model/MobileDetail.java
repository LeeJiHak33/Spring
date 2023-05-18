package kr.ac.kopo.boxgo.Model;

public class MobileDetail extends Detail {

	private String category;
	private String brand;
	private String size;
	private String color;
	
	@Override
	public String get(String key) {
		// TODO Auto-generated method stub
		if("category".equals(key)) {
			return "category";
		}
		else if("brand".equals(key)) {
			return "brand";
		}
		else if("size".equals(key)) {
			return "size";
		}
		else if("color".equals(key)) {
			return "color";
		}
		return null;
		
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
