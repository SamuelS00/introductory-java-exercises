package entities;

public class OrderItem {

	private Product product;
	private Integer quantity;
	private Double price;

	public OrderItem() {
	}

	public OrderItem(Product product, Integer quantity, Double price) {
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subTotal() {
		return price * quantity;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(product.getName() + ", ");
		sb.append("$" + String.format("%.2f", getPrice()) + ", ");
		sb.append("Quantity: " + getQuantity() + ", ");
		sb.append("Subtotal: " + "$" + String.format("%.2f", subTotal()));

		return sb.toString();
	}
}