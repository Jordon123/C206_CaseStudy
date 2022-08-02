import java.time.LocalDate;

public class Promotion extends FoodItem{
	LocalDate date;
	public Promotion(int id, String name, int price, LocalDate date){
		super(id, name, price);
		this.date = date;
	}
	
	public LocalDate getDate(){
		return date;		
	}
}
