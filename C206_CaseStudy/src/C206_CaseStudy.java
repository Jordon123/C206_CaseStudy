import java.time.LocalDate;
import java.util.ArrayList;

public class C206_CaseStudy {
	private static final int MAX_STALL = 10;
	private ArrayList<Stall> stallArr = new ArrayList<Stall>();
	private ArrayList<FoodItem> foodItemArr = new ArrayList<FoodItem>();
	public static void main(String[] args) {
		// Creating Array for Stalls
		C206_CaseStudy csa = new C206_CaseStudy();
		csa.start();
	}
	public void start() {
		ArrayList<Stall> stallArr = new ArrayList<Stall>();
		ArrayList<FoodItem> foodItemArr = new ArrayList<FoodItem>();
		int ans = 1;
		while(ans != 5) {
			mainMenu();
			ans = Helper.readInt("enter>");
			if(ans == 1) {
				menu();
			}
			else if(ans == 2) {
				stallMenu();
				int choice1 = Helper.readInt("Choice > ");
				if(choice1 == 1) {
					addStall();
				}
				else if(choice1 == 2) {
					viewAllStall();
				}
				else if(choice1 == 3) {
					changeStall();
				}
				else if(choice1 == 4) {
					deleteStall();
				}
				
			}
			else if(ans == 3) {
				foodItemMenu();
				int choice2 = Helper.readInt("Choice > ");
				if(choice2 == 1) {
					addFoodItem();
				}
				else if(choice2 == 2) {
					viewAllFoodItem();
				}
				else if(choice2 == 3) {
					changeFoodItem();
				}
				else if(choice2 == 4) {
					deleteFoodItem();
				}
			}
			else if(ans == 4) {
				//todo
			}
			else if (ans == 4) {
				System.out.println("End");
			}
		}
	}
	private void mainMenu() {
		System.out.println("WELCOME SDAUHWDWAND");
		System.out.println("1. Menu");
		System.out.println("2. Stall");
		System.out.println("3. Food Item");
		System.out.println("4. IDK");
	}
	
	//------------------------------------------------------Stall----------------------------------------------------------------
	private void stallMenu() {
		System.out.println("1. Add");
		System.out.println("2. View");
		System.out.println("3. Change");
		System.out.println("4. Remove");
	}
	// Method to add stall. 
	private  void addStall() {
		if(stallArr.size()<MAX_STALL) {
			stallArr.add(inputStall());
		}
		else if(stallArr.size() >= MAX_STALL) {
			System.out.println("Maximum Stall Reached!");
		}
	}
		// Method to delete stall.
	private void deleteStall() {
		viewAllStall();
		int id = Helper.readInt("stall id to delete> ");
		for(Stall s: stallArr) {
			if(s.getId() == id) {
					stallArr.remove(s);
			}
		}
	}
		//Method to change an existing stall
	private void changeStall() {
		viewAllStall();
		int id = Helper.readInt("Id");
		for(Stall s: stallArr) {
			if(s.getId() == id) {
					//todo - set all the values except id using setter in stall.java
			}
		}	
	}
		// Method to view an existing stall
	private void viewStall() {
		viewAllStall();
	}
	private Stall inputStall() {
		int id = Helper.readInt("Enter asset tag > ");
		String name = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");
		String operationDate = Helper.readString("Enter asset tag > ");
		String operationTime= Helper.readString("Enter asset tag > ");
		String category= Helper.readString("Enter asset tag > ");
		String operator= Helper.readString("Enter asset tag > ");
		Stall st = new Stall(id, name, LocalDate.parse(operationDate),  operationTime, 
				 category, operator);
		return st;
	}
	private void viewAllStall() {
		String output = String.format("%-5s %-15s %-15s %-10s %-15s %-10s\n", "ID","Name","Operation Date","Operation Time","Category","Operator");
		for(Stall s: stallArr) {
			output+=String.format("%-5d %-15s %-15s %-10s %-15s %-10s\n", s.getId(),s.getName(),s.getOperationDate().toString(),s.getOperationTime(),s.getCategory(),s.getOperator());
		}
		System.out.println(output);
	}
	//------------------------------------------------------FoodItem----------------------------------------------------------------
	private void foodItemMenu() {
		System.out.println("1. Add");
		System.out.println("2. View");
		System.out.println("3. Change");
		System.out.println("4. Remove");
	}
	// Method to add FoodItem. 
	private void addFoodItem() {
		if(inputFoodItem() != null) {
			foodItemArr.add(inputFoodItem());
			System.out.println("added");
		}
		else {
			System.out.println("price not within 3-15$");
		}
	}
	private void changeFoodItem() {
		viewAllFoodItem();
		int id = Helper.readInt("Food id to change");
		int price = Helper.readInt("price");
		for(FoodItem f:foodItemArr) {
			if(f.getId() == id) {
				//todo - set all the values except id using setter in fooditem.java
			}
		}
	}
	// Method to delete FoodItem.
	private void deleteFoodItem() {
		viewAllFoodItem();
		int id = Helper.readInt("Food id to delete");
		for(FoodItem f:foodItemArr) {
			if(f.getId() == id) {
				stallArr.remove(f);
			}
		}
	}
	private void menu() {
		viewAllFoodItem();
		viewPromotionFoodItem();
	}
	private FoodItem inputFoodItem() {
		FoodItem fI = null;
		int id = Helper.readInt("id");
		String name = Helper.readString("Name");
		int price = Helper.readInt("Price");
		char promotion = Helper.readChar("Promotion item ? (y/n)");
		if(price<=15 && price>=3) {
			if(promotion == 'y') {
				fI = new FoodItem( id,  name,  price, true);
			}
			else if(promotion == 'n') {
				fI = new FoodItem( id,  name,  price);
			}
			
		}
		return fI;
	}
	private void viewAllFoodItem() {
		String output = String.format("%-5s %-15s %-10s\n", "ID","Name","Price");
		for(FoodItem f:foodItemArr) {
			if(!f.isPromotion()) {
				output+=String.format("%-5d %-15s %-10d\n", f.getId(),f.getName(),f.getPrice());
			}
		}
		System.out.println(output);
	}
	private void viewPromotionFoodItem() {
		String output = "Promotion Item!\n";
		for(FoodItem f:foodItemArr) {
			if(f.isPromotion()) {
				output=String.format("%-5d %-15s %-10d\n", f.getId(),f.getName(),f.getPrice());
			}
		}
		System.out.println(output);
	}
	//------------------------------------------------------order----------------------------------------------------------------
	
}
