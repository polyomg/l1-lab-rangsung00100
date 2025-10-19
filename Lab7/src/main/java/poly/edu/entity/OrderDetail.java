package poly.edu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrdersDetails")
public class OrderDetail {

	private Long id;
	private Order orders;
	private Product products;
	private Double price;
	private Integer quanlity;

	public OrderDetail() {
	}

	public OrderDetail(Order orders, Product products, Double price, Integer quanlity) {
		this.orders = orders;
		this.products = products;
		this.price = price;
		this.quanlity = quanlity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderID")
	public Order getOrders() {
		return this.orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Products")
	public Product getProducts() {
		return this.products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	@Column(name = "Price", precision = 53, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "Quanlity")
	public Integer getQuanlity() {
		return this.quanlity;
	}

	public void setQuanlity(Integer quanlity) {
		this.quanlity = quanlity;
	}

}
