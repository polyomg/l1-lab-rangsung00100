package poly.edu.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.ToString;

@Entity
@Table(name = "Products")
@ToString
public class Product {

	private Integer id;
	private Category categories;
	private String name;
	private String image;
	private Double price;
	private Date createDate;
	private Boolean available;
	private List<OrderDetail> ordersDetailses;

	public Product() {
	}

	public Product(Category categories, String name, String image, Double price, Date createDate, Boolean available,
			List<OrderDetail> ordersDetailses) {
		this.categories = categories;
		this.name = name;
		this.image = image;
		this.price = price;
		this.createDate = createDate;
		this.available = available;
		this.ordersDetailses = ordersDetailses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CateloryID")
	public Category getCategories() {
		return this.categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	@Column(name = "Name")
	@Nationalized
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "Price", precision = 53, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Create_Date", length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date create_Date) {
		this.createDate = create_Date;
	}

	@Column(name = "Available")
	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public List<OrderDetail> getOrdersDetailses() {
		return this.ordersDetailses;
	}

	public void setOrdersDetailses(List<OrderDetail> ordersDetailses) {
		this.ordersDetailses = ordersDetailses;
	}

}
