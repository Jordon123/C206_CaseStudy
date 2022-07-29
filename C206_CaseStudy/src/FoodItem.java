import java.time.LocalDate;

//done by joel
public class FoodItem {
	private int id;
	private String name;
	private int price;
	private boolean promotion;
	private int promotionPrice;
	public FoodItem(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
		promotion = false;
	}
	public FoodItem(int id, String name, int price, boolean prm, int promotionPrice) {
		this.id = id;
		this.name = name;
		this.price = price;
		promotion = prm;
		this.promotionPrice = promotionPrice;
	}
	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}
	public int getPromotionPrice() {
		return promotionPrice;
	}
	public void setPromotionPrice(int promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isPromotion() {
		return promotion;
	}
	public void setName(String name) {
		this.name = name;
	}
}
