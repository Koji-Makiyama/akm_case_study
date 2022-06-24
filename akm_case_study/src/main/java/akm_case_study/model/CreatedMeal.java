package akm_case_study.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "created_meal")
public class CreatedMeal {

	public CreatedMeal() {
	}
	

	public CreatedMeal(Long id, String side, String entree, String dessert, String createdMealName,
			LocalDateTime dateCreated, List<FoodItem> mealItems, Long collectionId, User user) {
		this.id = id;
		this.side = side;
		this.entree = entree;
		this.dessert = dessert;
		this.createdMealName = createdMealName;
		this.dateCreated = dateCreated;
		this.mealItems = mealItems;
		this.collectionId = collectionId;
		this.user = user;
	}
	
	// NOT THE SAME AS ABOVE, ABOVE CONTAINS NEW FORMAT OF SIDE-ENTREE-DESSERT
	public CreatedMeal(String createdMealName, LocalDateTime dateCreated, List<FoodItem> mealItems,
			Long collectionId, User user) {
		super();
		this.createdMealName = createdMealName;
		this.dateCreated = dateCreated;
		this.mealItems = mealItems;
		this.collectionId = collectionId;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="created_meal_id")
	private Long id;
	
	@Column(name="side")
	private String side;
	
	@Column(name="entree")
	private String entree;
	
	@Column(name="dessert")
	private String dessert;
	
	@Column(name="created_meal_name")
	private String createdMealName; 
	
	@Column(name="date_created")
	private LocalDateTime dateCreated;

	@OneToMany(mappedBy="createdMeal")
	private List<FoodItem> mealItems;  // allows a created_meal to have MANY food items 
	
	//@ManyToOne
	//@JoinColumn(name="collection_id", nullable=false)
	private Long collectionId;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false) 
	private User user;

	public Long getId() {
		return id;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getEntree() {
		return entree;
	}

	public void setEntree(String entree) {
		this.entree = entree;
	}

	public String getDessert() {
		return dessert;
	}

	public void setDessert(String dessert) {
		this.dessert = dessert;
	}

	public String getCreatedMealName() {
		return createdMealName;
	}

	public void setCreatedMealName(String createdMealName) {
		this.createdMealName = createdMealName;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<FoodItem> getMealItems() {
		return mealItems;
	}

	public void setMealItems(List<FoodItem> mealItems) {
		this.mealItems = mealItems;
	}

	public Long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(Long collectionId) {
		this.collectionId = collectionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "CreatedMeal [id=" + id + ", side=" + side + ", entree=" + entree + ", dessert=" + dessert
				+ ", createdMealName=" + createdMealName + ", dateCreated=" + dateCreated + ", mealItems=" + mealItems
				+ ", collectionId=" + collectionId + ", user=" + user + "]";
	}
	
	
}
