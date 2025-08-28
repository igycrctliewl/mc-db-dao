package mb.minecraft.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Item extends mb.minecraft.model.Item {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO, generator="ITEM_ID_SEQ" )
	@Column( name = "ID" )
	private Integer id;

	@Column( name = "NAME", unique = true, nullable = false, length = 64 )
	private String name;

	@Column( name = "IMAGE_SOURCE" )
	private String imageSource;

}