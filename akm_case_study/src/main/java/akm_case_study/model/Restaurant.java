package akm_case_study.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="restaurant_id")
	private Long id;
	
	@Column(name="restaurant_name")
	private String restaurantName;
	
	@OneToMany(mappedBy="restaurant")
	public List<FoodItem> menu;

	public List<FoodItem> getMenu() {
		return menu;
	}

	public void setMenu(List<FoodItem> menu) {
		this.menu = menu;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", restaurantName=" + restaurantName + ", menu=" + menu + "]";
	}

	
//	public void setId(Long id) {
//		this.id = id;
//	}
	


}
