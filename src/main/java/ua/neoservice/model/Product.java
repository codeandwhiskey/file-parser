package ua.neoservice.model;

import java.math.BigDecimal;

public class Product {
	private int id;
	private String auto;
	private String code;
	private String number;
	private String analog;
	private String brand;
	private String description;
	private String model;
	private BigDecimal price;
	
	public Product(String auto, String code, String number,
			String analog, String brand, String description, String model, BigDecimal price) {
		this.auto = auto;
		this.code = code;
		this.number = number;
		this.analog = analog;
		this.brand = brand;
		this.description = description;
		this.model = model;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAnalog() {
		return analog;
	}

	public void setAnalog(String analog) {
		this.analog = analog;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}
}