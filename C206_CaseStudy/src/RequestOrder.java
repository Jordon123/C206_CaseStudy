
public class RequestOrder {
	private int id;
	private String name;
	private boolean orderStatus;
	private String order;
	public RequestOrder(int id, String name, String order) {
		this.id = id;
		this.name = name;
		this.order = order;
		orderStatus = false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getId() {
		return id;
	}
	public String orderStatus() {
		if(isOrderStatus()) {
			return "Order Completed";
		}
		else {
			return "Processing";
		}
	}
	
	
}
