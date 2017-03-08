package my.spring.test.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class InventoryItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String description;
	
	private String year;
	
	private String model;
	
	private String make;
	
	public InventoryItem() {
		
	}
	
	public InventoryItem(Long idParam) {
		super();
		id = idParam;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long idParam) {
		id = idParam;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String yearParam) {
		year = yearParam;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String modelParam) {
		model = modelParam;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String makeParam) {
		make = makeParam;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String descriptionParam) {
		description = descriptionParam;
	}

	
	
	@Override
	public String toString() {
		return "[id=" + getId() + " make=" + getMake() + " model=" + getModel() + " year=" + getYear() + "]";
	}
	
}
