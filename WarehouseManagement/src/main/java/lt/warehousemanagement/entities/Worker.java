package lt.warehousemanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="worker")
public class Worker {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	
	String name;
	String email;
	
	public Worker() {}

	public Worker(String name, String email) {
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}
