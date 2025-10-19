package poly.edu.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@ToString
@Table(name = "Categories")
public class Category {

	private String id;
	private String name;
	private List<Product> productses;

	public Category() {
	}

	public Category(String id) {
		this.id = id;
	}

	public Category(String id, String name, List<Product> productses) {
		this.id = id;
		this.name = name;
		this.productses = productses;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 4)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public List<Product> getProductses() {
		return this.productses;
	}

	public void setProductses(List<Product> productses) {
		this.productses = productses;
	}

}
