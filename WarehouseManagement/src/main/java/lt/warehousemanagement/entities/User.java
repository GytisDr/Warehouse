package lt.warehousemanagement.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data //Lombok: includes @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together
@NoArgsConstructor //we need them because empty constructor 
@AllArgsConstructor //is rewritten by Lombok's @Data
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	String username;
	String password;
	
	//Loads roles ASAP when User is loaded
	@ManyToMany(fetch = FetchType.EAGER)
	Collection<Role> roles = new ArrayList<>();
	
	public void addRole(Role role) {
        this.roles.add(role);
	}
 

}
