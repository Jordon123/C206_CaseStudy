import java.time.LocalDate;

//done by joel
public class FoodItem {
	private int id;
	private String name;
	private int price;
	private boolean promotion;
	public FoodItem(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
		promotion = false;
	}
	public FoodItem(int id, String name, int price, boolean prm) {
		this.id = id;
		this.name = name;
		this.price = price;
		promotion = prm;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isPromotion() {
		return promotion;
	}
}
