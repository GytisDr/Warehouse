package lt.warehousemanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lt.warehousemanagement.utils.ArithmeticUtils;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	
	String managerName;
	
	@OneToMany
	List<Product> products = new ArrayList<Product>();
	
	public Order() {}

	public Order(String managerName, List<Product> products) {
		this.managerName = managerName;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double totalAmount() {

		return products.stream()
		  .map(p -> p.getPrice())
		  .reduce((double) 0, ArithmeticUtils::add);
		  
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", managerName=" + managerName + ", products=" + products + "]";
	}

}
