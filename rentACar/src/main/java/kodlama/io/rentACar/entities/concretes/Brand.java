package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*lombok otomatik olarak getter setter
  vb degerleri otomatık olarak class içinde varmış gibi gösterir */

@Table(name = "brands")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {
	@Column(name = "name")
	private String name;
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) // otomatik artişı sağlar
	@Column(name = "id")
	private int id;
	
	@OneToMany(mappedBy="brand")
	private List<Model> models;

}
