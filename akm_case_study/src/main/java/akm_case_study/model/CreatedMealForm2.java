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

public class CreatedMealForm2 {

		private String createdMealName; 
		
		// private LocalDateTime dateCreated;

		//@OneToMany(mappedBy="createdMeal")
		//private List<FoodItem> mealItems;  // allows a created_meal to have MANY food items
		
		private String side;
		private String entree;
		private String dessert;
		
		public String getCreatedMealName() {
			return createdMealName;
		}

		public void setCreatedMealName(String createdMealName) {
			this.createdMealName = createdMealName;
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
		
		/*
		public LocalDateTime getDateCreated() {
			return dateCreated;
		}

		public void setDateCreated(LocalDateTime dateCreated) {
			this.dateCreated = dateCreated;
		}
*/

        

		
	}
