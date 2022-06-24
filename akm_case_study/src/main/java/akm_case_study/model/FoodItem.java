package akm_case_study.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "food_item")
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="food_item_id")
	private Long id;
	
	@Column(name="food_name")
	public String foodName;
	
	@Column(name="food_category")
	public String foodCategory; // entree, side, dessert
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // changed to @ManyToMany
	@JoinTable(
			name = "created_meals_food_items",
			joinColumns = @JoinColumn(
		            name = "food_item_id", referencedColumnName = "food_item_id"),
			inverseJoinColumns = @JoinColumn(
				            name = "created_meal_id"))
	private List<FoodItem> createdMeal;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // changed to @ManyToMany
	@JoinTable(
			name = "restaurant_food_items",
			joinColumns = @JoinColumn(
		            name = "food_item_id", referencedColumnName = "food_item_id"),
			inverseJoinColumns = @JoinColumn(
				            name = "restaurant_id"))
	private List<FoodItem> restaurant;
	
	/*
	 * 	
	 * Inside of CLASS USER...
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",        // TOP + BOTTOM
			joinColumns = @JoinColumn(
		            name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
				            name = "role_id", referencedColumnName = "id"))
	
	private Collection<Role> roles;
	 */
	
	public String getFoodName() {
		return foodName;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	
	public String getFoodCategory() {
		return foodCategory;
	}
	
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", foodName=" + foodName + ", foodCategory=" + foodCategory + ", createdMeal="
				+ createdMeal + ", restaurant=" + restaurant + "]";
	}

	
	//public void setId(Long id) {
	//	this.id = id;
	//}
	
	
	
}
