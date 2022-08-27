package lt.warehousemanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	
	String managerName;
	double price;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Product> products = new ArrayList<Product>();
	
	public Order() {}

	public Order(String managerName, int quantity) {
		this.managerName = managerName;
	}

	public Order(String managerName, int quantity, double price, List<Product> products) {
		this.managerName = managerName;
		this.price = price;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", managerName=" + managerName + ", products=" + products + "]";
	}

}
