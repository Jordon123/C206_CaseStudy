import java.time.LocalDate;

//done by joel
public class FoodItem {
	private int id;
	private String name;
	private int price;
	private boolean promotion;
	private int promotionPrice;
	private LocalDate promotionDate;
	public LocalDate getPromotionDate() {
		return promotionDate;
	}
	public void setPromotionDate(LocalDate promotionDate) {
		this.promotionDate = promotionDate;
	}
	public FoodItem(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
		promotion = false;
	}
	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}
	public boolean getPromotion() {
		return promotion;
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
