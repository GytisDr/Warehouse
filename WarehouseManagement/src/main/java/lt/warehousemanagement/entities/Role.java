package lt.warehousemanagement.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String name;
	 
    public Role() {}
    
    public Role(String name) {
        this.name = name;
    }
     
    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public Role(Integer id) {
        this.id = id;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
    
}