package mb.minecraft.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "VILLAGE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Village extends mb.minecraft.model.Village {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "ID" )
	private Integer id;

	@Column( name = "NAME", unique = true )
	private String name;


//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append( super.toString() );
//		return sb.toString();
//	}

}