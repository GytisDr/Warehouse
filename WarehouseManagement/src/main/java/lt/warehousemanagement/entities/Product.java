package lt.warehousemanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	
	String name;
	String description;
	String location;
	double price;
	String barcode;
	
	public Product() {}

	public Product(String name, String description, String location, double price, String barcode) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.price = price;
		this.barcode = barcode;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", price=" + price + ", barcode=" + barcode + "]";
	}

}
