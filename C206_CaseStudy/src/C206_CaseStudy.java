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
	private ArrayList<Order> orderArr = new ArrayList<Order>();
	public static void main(String[] args) {
		// Creating Array for Stalls
		C206_CaseStudy csa = new C206_CaseStudy();
		csa.start();
		
	}
	public void start() {
		Stall stall1 = new Stall(1, "stall1", LocalDate.of(2020,10,3),"10:00am","Western & Chinese", "Jordon");
		stallArr.add(stall1);
		Order order1 = new Order(1, "order1", "orderStall1", "Chicken Rice", 3);
		orderArr.add(order1);
		RequestOrder reqOrder1 = new RequestOrder(1, "reqOrder1", "order1");
		requestArr.add(reqOrder1);
		FoodItem foodItem1 = new FoodItem(1,"Chicken Rice",3);
		FoodItem foodItem2 = new FoodItem(1,"Fish & Chips",7);
		foodItemArr.add(foodItem1);
		foodItem2.setPromotion(true);
		foodItemArr.add(foodItem2);
		int ans = 1;
		while(ans != 4) {
			mainMenu();
			ans = Helper.readInt("enter>");
			//canteen admin
			if(ans == 1) {
				canteenAdminMenu();
				int choice0 = Helper.readInt("Enter choice > ");
				if(choice0 == 1) {
					menu();
				}
				else if(choice0 == 2) {
					stallMenu();
					int choice1 = Helper.readInt("Choice > ");
					if(choice1 == 1) {
						addStall(stallArr, inputStall());
					}
					else if(choice1 == 2) {
						viewAllStall();
					}
					else if(choice1 == 3) {
						changeStall();
					}
					else if(choice1 == 4) {
						viewAllStall();
						int stallNumber = Helper.readInt("Enter Stall ID to delete: ");  
						deleteStall(stallArr, stallNumber);
					}
				}
				else if(choice0 == 3) {
					foodItemMenu();
					int choice2 = Helper.readInt("Choice > ");
					if(choice2 == 1) {
						addFoodItem(foodItemArr,inputFoodItem());
					}
					else if(choice2 == 2) {
						System.out.println(viewAllFoodItem(foodItemArr));
					}
					else if(choice2 == 3) {
						changeFoodItem();
					}
					else if(choice2 == 4) {
						System.out.println(viewAllFoodItem(foodItemArr));
						deleteFoodItem(foodItemArr, Helper.readInt("Enter id of item to be removed: "));
					}
				}
			}
			//stall operator
			else if(ans == 2) {
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
						addRequestOrder(requestArr, inputRequestOrder());
					}else if(choice4 == 2) {
						System.out.println(viewAllRequestOrder(requestArr));
					}else if(choice4 == 3) {
						//change rq order
						changeRequestOrder();
					}else if(choice4 == 4) {
						//delete req order
						System.out.println(viewAllRequestOrder(requestArr));
						removeRequestOrder(requestArr, Helper.readInt("Enter id: "));
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
			//customer
			else if(ans == 3) {
				customerMenu();
				int choice6 = Helper.readInt("Choice > ");
				if (choice6 == 1) {
					addOrder(orderArr, inputOrder());
				} else if (choice6 == 2) {
					System.out.println(viewAllOrder(orderArr));
				} else if (choice6 == 3) {
					deleteOrder(orderArr,Helper.readInt("Enter id to delete > "));
				}
				
			}
			else if(ans == 4) {
				System.out.println("End");
				
			}
			
		}
	}
	private void mainMenu() {
		System.out.println("WELCOME TO CAS");
		System.out.println("1. Canteen Administrator");
		System.out.println("2. Stall Operator");
		System.out.println("3. Customer");
		System.out.println("4. Exit");
	}
	
	//------------------------------------------------------Stall----------------------------------------------------------------
	private void canteenAdminMenu() {
		System.out.println("1. Menu");
		System.out.println("2. Stall");
		System.out.println("3. Food Item");
		System.out.println("4. Exit");
	}
	private void stallMenu() {
		System.out.println("1. Add");
		System.out.println("2. View");
		System.out.println("3. Change");
		System.out.println("4. Remove");
	}
	private void foodItemMenu() {
		System.out.println("1. Add");
		System.out.println("2. View");
		System.out.println("3. Change");
		System.out.println("4. Remove");
	}
	private void customerMenu() {
		System.out.println("1. Add");
		System.out.println("2. View");
		System.out.println("3. Change");
		System.out.println("4. Remove");
	}
	// Method to add stall. 
	public static void addStall(ArrayList<Stall> stallArr, Stall stallNumber) {
		if(stallArr.size()<MAX_STALL) {
			stallArr.add(stallNumber);
		}
		else if(stallArr.size() >= MAX_STALL) {
			System.out.println("Maximum Stall Reached!");
		}
	}
		// Method to delete stall.
	public static void deleteStall(ArrayList<Stall> stallArr, int stallNumber) {
		for(int i = 0; i < stallArr.size(); i++) {
			if(stallArr.get(i).getId() == stallNumber) {
				stallArr.remove(i);
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
	public static String viewStall(ArrayList<Stall> stallArr, int StallID) {
		
		String output = "";
		//String output = String.format("%-5s %-15s %-15s %-10s %-15s %-10s\n", "Stall ID","Stall Name","Operation Date","Operation Time","Category","Operator Name");
		for(int i = 0; i < stallArr.size(); i++) {
			if(stallArr.get(i).getId() == StallID) {
				Stall s = stallArr.get(i);
				output = String.format("%-5d %-15s %-15s %-10s %-15s %-10s\n", s.getId(),s.getName(),s.getOperationDate().toString(),s.getOperationTime(),s.getCategory(),s.getOperator());
			}
		}
		return output;
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
		String output = String.format("%-10s %-15s %-15s %-15s %-15s %-10s\n", "Stall ID","Stall Name","Operation Date","Operation Time","Category","Operator Name");
		for(Stall s: stallArr) {
			output+=String.format("%-10d %-15s %-15s %-15s %-15s %-10s\n", s.getId(),s.getName(),s.getOperationDate().toString(),s.getOperationTime(),s.getCategory(),s.getOperator());
		}
		System.out.println(output);
	}
	//------------------------------------------------------FoodItem----------------------------------------------------------------

	// Method to add FoodItem. 
	public static void addFoodItem(ArrayList<FoodItem> foodItemArr, FoodItem fooditem1) {
		if(fooditem1.getPrice()>=3 && fooditem1.getPrice() <= 15) {
			foodItemArr.add(fooditem1);
			System.out.println("added");
		}
		else {
			System.out.println("price not within 3-15$");
		}
	}
	private void changeFoodItem() {
		viewAllFoodItem(foodItemArr);
		int id = Helper.readInt("Food id to change");
		String name = Helper.readString("name > ");
		int price = Helper.readInt("price > ");
		for(FoodItem f:foodItemArr) {
			if(f.getId() == id) {
				f.setPrice(price);
				f.setName(name);
			}
		}
	}
	// Method to delete FoodItem.
	public static void deleteFoodItem(ArrayList<FoodItem> foodItemArr, int id) {
		for(int i = 0; i < foodItemArr.size(); i++) {
			if(foodItemArr.get(i).getId()==id) {
				foodItemArr.remove(i);
			}
		}
	}
	private void menu() {
		System.out.println(viewAllFoodItem(foodItemArr));
		viewPromotionFoodItem();
	}
	private FoodItem inputFoodItem() {
		FoodItem fI = null;
		int id = Helper.readInt("ID: ");
		String name = Helper.readString("Name: ");
		int price = Helper.readInt("Price: ");
		if(price<=15 && price>=3) {
			fI = new FoodItem( id,  name,  price);
		}
		return fI;
	}
	public static String viewAllFoodItem(ArrayList<FoodItem> foodItemArr) {
		String output = String.format("%-5s %-25s %-10s\n", "ID","Name","Price");
		for(FoodItem f:foodItemArr) {
			if(!f.isPromotion()) {
				output+=String.format("%-5d %-25s %-10d\n", f.getId(),f.getName(),f.getPrice());
			}
		}
		return output;
	}
	private void viewPromotionFoodItem() {
		//TODO - make it for entire week
		String output = "Promotion Item!\n";
		for(FoodItem f:foodItemArr) {
			if(f.isPromotion()) {
				output+=String.format("%-5d %-15s %-10d\n", f.getId(),f.getName(),f.getPrice());
			}
		}
		System.out.println(output);
	}
	//------------------------------------------------------Stall Operators----------------------------------------------------------------
	private void stallOpMenu() {
		System.out.println("1. View food items");
		System.out.println("2. Update request Order");
		System.out.println("3. request order");
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
//		viewAllRequestOrder();
		int id = Helper.readInt("Enter id to change status > ");
		char status = Helper.readChar("Order Completed? (y/n)");
		for(RequestOrder r: requestArr) {
			if(r.getId() == id && status == 'y') {
				r.setOrderStatus(true);
			}
		}
	}
	public static void addRequestOrder(ArrayList<RequestOrder> requestArr, RequestOrder requestOrder) {
		requestArr.add(requestOrder);
	}
	public static String viewAllRequestOrder(ArrayList<RequestOrder> requestArr) {
		String output = String.format("%-10s %-15s %-15s %s\n", "ID","Name","Order Status","order");
		for(RequestOrder r: requestArr) {
			output+= String.format("%-10d %-15s %-15s %s\n", r.getId(),r.getName(),r.orderStatus(),r.getOrder());
		}
		return output;
	}
	private void changeRequestOrder() {
//		viewAllRequestOrder();
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
	private void removeRequestOrder(ArrayList<RequestOrder> requestArr, int id) {
		viewAllRequestOrder(requestArr);
		for(int i = 0; i < requestArr.size(); i++) {
			if(requestArr.get(i).getId() == id) {
				requestArr.remove(i);
			}
		}
	}
	
	private RequestOrder inputRequestOrder() {
		RequestOrder rq = null;
		int id = Helper.readInt("ID > ");
		String name = Helper.readString("Name > ");
		String order = Helper.readString("Enter order items > ");
		rq = new RequestOrder(id,name,order);
		return rq;
	}
	private void addPromotion() {
		int id = Helper.readInt("id > ");
		boolean promotion = true;
		int promotionPrice;
		String promotionDate = Helper.readString("Enter Promotion Date > ");
		for( FoodItem f: foodItemArr ) {
			if(f.getId() == id) {
				promotionPrice = f.getPrice()-2;
				f.setPromotion(promotion);
				f.setPromotionPrice(promotionPrice);
				f.setPromotionDate(LocalDate.parse(promotionDate));
			}//done
		}
	}
	private void viewPromotion() {
		String output = "Promotion Item!\n";
		for(FoodItem f:foodItemArr) {
			if(f.isPromotion()) {
				if(f.getPromotionDate().isAfter(LocalDate.now()) && f.getPromotionDate().isBefore(f.getPromotionDate().plusDays(14))) {
					output=String.format("%-5d %-15s %-10d\n", f.getId(),f.getName(),f.getPrice());
				}
			}
		}
		System.out.println(output);
	}
	private void changePromotion() {
		//TODO
	}
	private void deletePromotion() {
		int id = Helper.readInt("Enter id > ");
		for(FoodItem f: foodItemArr) {
			if(f.isPromotion() && f.getId() == id) {
				foodItemArr.remove(f);
			}
		}
	}
	
	//------------------------------------------------------Customer----------------------------------------------------------------
	//customerorder
	
	public static void addOrder(ArrayList<Order> orderArr, Order order)  {
		orderArr.add(order);
	}
	
	public static String viewAllOrder(ArrayList<Order> orderArr) {
		String output = String.format("%-10s %-15s %-15s %-20s %-10s\n", "ORDER ID", "NAME", "STALL", "FOOD", "PRICE");
		for (Order order : orderArr) {
			output += String.format("%-10d %-15s %-15s %-20s %-10d\n", order.getId(), order.getName(), order.getStall(), order.getFood(), order.getPrice());
		}
		return output;
	}
	
	public static void deleteOrder(ArrayList<Order> orderArr, int id) {
		for (int i = 0; i < orderArr.size(); i++) {
			if (orderArr.get(i).getId() == id) {
				orderArr.remove(i);
			}
		}
	}
	
	private Order inputOrder() {
		Order or;
		int id = Helper.readInt("Id > ");
		String name = Helper.readString("Name > ");
		String stall = Helper.readString("Stall Name > ");
		String food = Helper.readString("Enter Food");
		int price = Helper.readInt("Price > ");
		or = new Order(id,name,stall,food,price);
		return or;
	}
}
