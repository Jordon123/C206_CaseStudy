import java.time.LocalDate;

//for customer order
public class Order{
	private int id;
	private String name;
	private String stall;
	private String food;
	private int price;
	
	public Order(int id, String name, String stall, String food, int price) {
		this.id = id;
		this.name = name;
		this.stall = stall;
		this.food = food;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStall() {
		return stall;
	}

	public String getFood() {
		return food;
	}

	public int getPrice() {
		return price;
	}
	
	
}
