import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

//need to change all the helper. texts to proper sentences
public class C206_CaseStudy {
	private static final int MAX_STALL = 10;
	private ArrayList<Stall> stallArr = new ArrayList<Stall>();
	private ArrayList<FoodItem> foodItemArr = new ArrayList<FoodItem>();
	private ArrayList<RequestOrder> requestArr = new ArrayList<RequestOrder>();
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
				stallOpMenu();
				int choice3 = Helper.readInt("Choice > ");
				if(choice3 == 1) {
					menu();
				}
				else if (choice3 == 2) {
					updateRequestStatus();
				}
				else if (choice3 == 3) {
					stallReqOrMenu();
					int choice4 = Helper.readInt("choice");
					if (choice4 == 1) {
						//add req ord
						addRequestOrder();
					}else if(choice4 == 2) {
						//view req order
						viewAllRequestOrder();
					}else if(choice4 == 3) {
						//change rq order
						changeRequestOrder();
					}else if(choice4 == 4) {
						//delete req order
						removeRequestOrder();
					}
				}
				else if (choice3 == 4) {
					dailyPromMenu();
					int choice5 = Helper.readInt("Choice > ");
					if(choice5 == 1) {
						addPromotion();
					}else if(choice5 == 2) {
						viewPromotion();
					}else if(choice5 == 3) {
						changePromotion();
					}else if(choice5 == 4) {
						deletePromotion();
					}
				}
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
		System.out.println("4. Request Order");
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
		String name = Helper.readString("Name>");
		Date operationDate = Helper.readDate("OperationDate");
		String operationTime = Helper.readString("Operation Time");
		String category = Helper.readString("Cateogry");
		String operator =  Helper.readString("operator");
		for(Stall s: stallArr) {
			if(s.getId() == id) {
					//todo - set all the values except id using setter in stall.java
				s.setName(name);
				s.setOperationDate(LocalDate.parse(operationDate.toString()));
				s.setOperationTime(operationTime);
				s.setOperator(operator);
			}
		}	
	}
		// Method to view an existing stall
	private void viewStall() {
		viewAllStall();
	}
	private Stall inputStall() {
		int id = Helper.readInt("Enter Stall ID > ");
		String name = Helper.readString("Enter Stall Name > ");
		String operationDate = Helper.readString("Enter Operation Date > ");
		String operationTime= Helper.readString("Enter Operation Time > ");
		String category= Helper.readString("Enter Stall Category > ");
		String operator= Helper.readString("Enter Operator Name > ");
		Stall st = new Stall(id, name, LocalDate.parse(operationDate),  operationTime, 
				 category, operator);
		return st;
	}
	private void viewAllStall() {
		String output = String.format("%-5s %-15s %-15s %-10s %-15s %-10s\n", "Stall ID","Stall Name","Operation Date","Operation Time","Category","Operator Name");
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
		String name = Helper.readString("name > ");
		int price = Helper.readInt("price > ");
		for(FoodItem f:foodItemArr) {
			if(f.getId() == id) {
				//todo - set all the values except id using setter in fooditem.java
				f.setPrice(price);
				f.setName(name);
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
		if(price<=15 && price>=3) {
			fI = new FoodItem( id,  name,  price);
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
		//TODO - make it for entire week
		String output = "Promotion Item!\n";
		for(FoodItem f:foodItemArr) {
			if(f.isPromotion()) {
				output=String.format("%-5d %-15s %-10d\n", f.getId(),f.getName(),f.getPrice());
			}
		}
		System.out.println(output);
	}
	//------------------------------------------------------Stall Operators----------------------------------------------------------------
	private void stallOpMenu() {
		System.out.println("1. View food items");
		System.out.println("2. Update request status");
		System.out.println("3. Edit request order");
		System.out.println("4. Edit Daily promotion Offer");
		
	}
	private void stallReqOrMenu() {
		System.out.println("1. Add request order");
		System.out.println("2. view request order");
		System.out.println("3. change request order");
		System.out.println("4. remove request order");
	}
	private void dailyPromMenu() {
		System.out.println("1. Add daily promotion");
		System.out.println("2. view daily promotion");
		System.out.println("3. change daily promotion");
		System.out.println("4. remove daily promotion");
	}
	private void updateRequestStatus() {
		viewAllRequestOrder();
		int id = Helper.readInt("Enter id to change status > ");
		char status = Helper.readChar("Order Completed? (y/n)");
		for(RequestOrder r: requestArr) {
			if(r.getId() == id && status == 'y') {
				r.setOrderStatus(true);
			}
		}
	}
	private void addRequestOrder() {
		int id = Helper.readInt("Enter id");
		String name = Helper.readString("Order Name");
		String order = Helper.readString("Order Items");
		requestArr.add(new RequestOrder(id,name,order));
	}
	private void viewAllRequestOrder() {
		String output = String.format("%-10s %-15s %-10s %s", "ID","Name","Order Status","order");
		for(RequestOrder r: requestArr) {
			//TODO	- string.format print all request order in arr
			output+= String.format("%-10d %-15s %-10s %s", r.getId(),r.getName(),r.orderStatus(),r.getOrder());
					
		}
	}
	private void changeRequestOrder() {
		viewAllRequestOrder();
		int id = Helper.readInt("Enter id");
		String name = Helper.readString("update order Name");
		String order = Helper.readString("updated Order Items");
		for(RequestOrder r: requestArr) {
			if(r.getId() == id) {
				r.setName(name);
				r.setOrder(order);
			}
		}
	}
	private void removeRequestOrder() {
		viewAllRequestOrder();
		int id = Helper.readInt("Enter id");
		for(RequestOrder r: requestArr) {
			if(r.getId() == id) {
				requestArr.remove(r);
			}
		}
	}
	private void addPromotion() {
		int id = Helper.readInt("id > ");
		boolean promotion = true;
		int promotionPrice;
		for( FoodItem f: foodItemArr ) {
			if(f.getId() == id) {
				promotionPrice = f.getPrice()-2;
				f.setPromotion(promotion);
				f.setPromotionPrice(promotionPrice);
			}//done
		}
	}
	private void viewPromotion() {
		
	}
	private void changePromotion() {
		
	}
	private void deletePromotion() {
		
	}
	
	//------------------------------------------------------Customer----------------------------------------------------------------

}
