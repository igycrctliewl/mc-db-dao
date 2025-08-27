package mb.minecraft.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "VILLAGER_TYPE")
@Data
@EqualsAndHashCode(callSuper=false)
public class VillagerType extends mb.minecraft.model.VillagerType {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO, generator="VILLAGER_TYPE_ID_SEQ" )
	@Column( name = "ID" )
	private Integer id;

	@Column( name = "PROFESSION", unique = true )
	private String profession;


	public VillagerType() {
		this( "" );
	}

	public VillagerType( String profession ) {
		super( profession );
		this.setProfession( profession );
	}

}