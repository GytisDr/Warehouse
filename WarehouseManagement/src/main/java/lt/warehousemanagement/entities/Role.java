package lt.warehousemanagement.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="roles")
@Data //Lombok: includes @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together
@NoArgsConstructor //we need them because empty constructor 
@AllArgsConstructor //is rewritten by Lombok's @Data

public class Role {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	
}
