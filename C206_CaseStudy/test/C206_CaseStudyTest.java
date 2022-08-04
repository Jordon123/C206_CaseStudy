import static org.junit.Assert.*;

import java.util.ArrayList;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	// prepare test data
	private ArrayList<Stall> stallArr;
	private ArrayList<FoodItem> foodItemArr = new ArrayList<FoodItem>();
	private ArrayList<RequestOrder> requestArr = new ArrayList<RequestOrder>();
	private ArrayList<Order> orderArr = new ArrayList<Order>();
			
	private Stall stall1;
	private Stall stall2;
	private Stall stall3;
	private Stall stall4;
	private Stall stall5;
	private Stall stall6;
	private Stall stall7;
	private Stall stall8;
	private Stall stall9;
	private Stall stall10;
	private Stall stall11;
	
	private Order order1;
	private Order order2;
	private Order order3;
	
	private RequestOrder reqOrder1;
	private RequestOrder reqOrder2;
	private RequestOrder reqOrder3;
	
	@Before
	public void setUp() throws Exception {
		
		stall1 = new Stall(1, "stall1", LocalDate.of(2020,10,3),"10am","Western", "Jordon");
		stall2 = new Stall(2, "stall2", LocalDate.of(2020,11,13),"9am","Western", "Adi");
		stall3 = new Stall(3, "stall3", LocalDate.of(2020,11,13),"8am","Asian", "Joel");
		stall4 = new Stall(4, "stall4", LocalDate.of(2020,9,1),"9am","Asian", "Jordon1");
		stall5 = new Stall(5, "stall5", LocalDate.of(2020,9,1),"9am","Asian", "Jordon1");
		stall6 = new Stall(6, "stall6", LocalDate.of(2020,11,13),"9am","Western", "Adi");
		stall7 = new Stall(7, "stall7", LocalDate.of(2020,11,13),"9am","Western", "Adi");
		stall8 = new Stall(8, "stall8", LocalDate.of(2020,11,13),"9am","Western", "Adi");
		stall9 = new Stall(9, "stall9", LocalDate.of(2020,11,13),"9am","Western", "Adi");
		stall10 = new Stall(10, "stall10", LocalDate.of(2020,11,13),"9am","Western", "Adi");
		stall11 = new Stall(11, "stall11", LocalDate.of(2020,11,13),"9am","Western", "Fail");
		
		stallArr= new ArrayList<Stall>();
		
		// customer order
		order1 = new Order(1, "order1", "orderStall1", "orderFood1", 10);
		order2 = new Order(2, "order2", "orderStall2", "orderFood2", 25);
		order3 = new Order(3, "order3", "orderStall3", "orderFood3", 30);
		
		//Request Order
		reqOrder1 = new RequestOrder(1, "reqOrder1", "order1");
		reqOrder2 = new RequestOrder(1, "reqOrder2", "order2");
		reqOrder3 = new RequestOrder(1, "reqOrder3", "order3");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	@Test
	public void addStallTest() {
		
		//Test that there is a ArrayList to add to. //normal
		assertNotNull("Test if there is valid Stall arraylist to add to", stallArr);
		
		//Test that only one stall is added into the ArrayList. //boundary
		C206_CaseStudy.addStall(stallArr, stall1);
		assertEquals("Test that order arraylist size is 1?", 1, stallArr.size());

		
		//Test that the stall added into the Array contains all the right information. //normal
		assertSame("Test that Stall is added same as 1st item of the list?", stall1, stallArr.get(0));
		
		C206_CaseStudy.addStall(stallArr, stall2);
		C206_CaseStudy.addStall(stallArr, stall3);
		C206_CaseStudy.addStall(stallArr, stall4);
		C206_CaseStudy.addStall(stallArr, stall5);
		C206_CaseStudy.addStall(stallArr, stall6);
		C206_CaseStudy.addStall(stallArr, stall7);
		C206_CaseStudy.addStall(stallArr, stall8);
		C206_CaseStudy.addStall(stallArr, stall9);
		C206_CaseStudy.addStall(stallArr, stall10);
		
		//Test that ArrayList cannot contain more than 10 Stalls. //error
		C206_CaseStudy.addStall(stallArr, stall11);
		assertNotEquals("Test if that Stall arraylist size is 11?",11, stallArr.size());
		
	}
	
	@Test
	public void deleteStallTest() {
		
		//Test that ArrayList is valid //normal
		assertNotNull("Test if there is valid Stall arraylist to add to", stallArr);
		
		//Test that delete function would work. //normal
		C206_CaseStudy.addStall(stallArr, stall1);
		C206_CaseStudy.deleteStall(stallArr, 1);	
		assertEquals("Test if that Stall arraylist size is 0?",0, stallArr.size());
		
		//Test that delete function will not delete 2 stalls //error
		C206_CaseStudy.addStall(stallArr, stall1);
		C206_CaseStudy.addStall(stallArr, stall2);
		C206_CaseStudy.deleteStall(stallArr, 2);	
		assertNotEquals("Test if that Stall ArrayList size is not 0?",0, stallArr.size());
		
		//Clear the List
		stallArr.clear();
		
		//Test that only 1 stall is deleted //boundary
		C206_CaseStudy.addStall(stallArr, stall1);
		C206_CaseStudy.addStall(stallArr, stall2);
		C206_CaseStudy.deleteStall(stallArr, 2);	
		assertEquals("Test if that Stall arraylist size is 1?",1, stallArr.size());
	}
	
		@Test
	public void viewStallTest() {
		
		//test that nothing can be viewed if there are no stalls in ArrayList.//error condition
		String checkStalls = C206_CaseStudy.viewStall(stallArr, 1);
		String testOutput2 = "";
		assertEquals(testOutput2, checkStalls);

		C206_CaseStudy.addStall(stallArr, stall1);
		
		//test if the expected output string same as the stall in the arrayList //normal
		String testOutput = "";
		testOutput = String.format("%-5d %-15s %-15s %-10s %-15s %-10s\n",1, "stall1", LocalDate.of(2020,10,3),"10am","Western", "Jordon");			
		assertEquals(testOutput, C206_CaseStudy.viewStall(stallArr, 1));
		
		//test that only 1 item will be displayed when viewStall is used //normal
		String checkNumStalls = C206_CaseStudy.viewStall(stallArr, 1);
		int testOutputNum = 1;
		assertEquals(checkNumStalls.lines().count(), 1);
		
		C206_CaseStudy.addStall(stallArr, stall2);
		C206_CaseStudy.addStall(stallArr, stall3);
		C206_CaseStudy.addStall(stallArr, stall4);
		C206_CaseStudy.addStall(stallArr, stall5);
		C206_CaseStudy.addStall(stallArr, stall6);
		C206_CaseStudy.addStall(stallArr, stall7);
		C206_CaseStudy.addStall(stallArr, stall8);
		C206_CaseStudy.addStall(stallArr, stall9);
		C206_CaseStudy.addStall(stallArr, stall10);
		
		//test that user cannot view the 11th stall outside the max range(10) //boundary
		C206_CaseStudy.addStall(stallArr, stall11);
		String testOutput3 = "";
		assertEquals(testOutput3, C206_CaseStudy.viewStall(stallArr, 11));
		
	}
	
	//-------------------------------------------------------customer test--------------------------------------------------------
		
	@Test
	public void doAddOrder() {
		
		// Check list is not null, so can add new order
		assertNotNull("Test if there is valid Order arraylist to add to", orderArr);
		
		// Add to orderArr
		C206_CaseStudy.addOrder(orderArr, order1);
		assertEquals("Test if that orderArr arraylist size is 1?", 1, orderArr.size());
		
		// The item just added is as same as the first item of the list
		assertSame("Test that order is added same as 1st item of the list?", order1, orderArr.get(0));
		
		// Add another item. Test The size of the list is 2
		C206_CaseStudy.addOrder(orderArr, order2);
		assertEquals("Test that order arraylist size is 2?", 2, orderArr.size());
		
		// Test that item added is from correct stall
		assertEquals("Test if that order is from correct stall?", "orderStall2", orderArr.get(1).getStall());
		
		// Test order price matches
		assertEquals("Test if that order price is displayed same?", 25, orderArr.get(1).getPrice());
	}
	
	
	@Test
	public void doViewAllOrder() {
		
		// Check if arrayList is empty at the Beginning
		assertNotNull("Test that arrayList is empty", orderArr);
				
		// Test that all the orders in check out is added/displayed
		C206_CaseStudy.addOrder(orderArr, order1);
		assertTrue(C206_CaseStudy.viewAllOrder(orderArr).contains("order1"));
				
		// Test that arrangement of the orders is displayed chronologically
		assertSame("Test that order is added same as 1st order of the list?", 1, orderArr.get(0).getId());
				
		// Test the orders stall name matches
		assertSame("Test if name of order's stall matches?", "orderStall1", orderArr.get(0).getStall());
		
		// Test the total price of an order is calculated correctly
		assertEquals("Test if total price of this order is displayed correctly?", 10, orderArr.get(0).getPrice()); 
	}	
	
	@Test
	public void doDeleteOrder() {
		
		// Check if arrayList is empty at the Beginning
		assertNotNull("Test that arrayList is empty", orderArr);
		
		// Test when delete, only 1 order is removed
		C206_CaseStudy.addOrder(orderArr, order1);
		C206_CaseStudy.addOrder(orderArr, order2);
		C206_CaseStudy.deleteOrder(orderArr, 1);
		assertNotEquals("Test order arraylist size is not 0?", 0, orderArr.size());
		
		
		orderArr.clear();
		// Test if order cancelled, no. of order decrease by 1
		C206_CaseStudy.addOrder(orderArr, order1);
		C206_CaseStudy.addOrder(orderArr, order2);
		C206_CaseStudy.addOrder(orderArr, order3);
		C206_CaseStudy.deleteOrder(orderArr, 3);
		assertSame("Test if order deleted is correct?", 2, orderArr.size()); 
		
		orderArr.clear();
		// Test that when order is deleted, it is removed from list
		C206_CaseStudy.addOrder(orderArr, order1);
		C206_CaseStudy.addOrder(orderArr, order2);
		C206_CaseStudy.deleteOrder(orderArr, 1);
		assertSame("Test if that order arraylist size is 1?", 1, orderArr.size());
		
		orderArr.clear();
		// Test that an order deleted is correct order customer selected
		C206_CaseStudy.addOrder(orderArr, order1);
		C206_CaseStudy.addOrder(orderArr, order2);
		C206_CaseStudy.addOrder(orderArr, order3);
		C206_CaseStudy.deleteOrder(orderArr, 3);
		assertNotEquals("Test if order deleted is correct?", 2, orderArr.get(0).getId());  
	}

	
	@Test
	public void addFoodItemTest() {
		foodItemArr.clear();
		//check if arraylist is empty at the beginning
		assertNotNull("Test if array is empty at start",foodItemArr);
		
		//add a new fooditem object to arraylist
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(1,"Chicken Rice",4));
		
		//check if arraylist contains new item that is added
		assertEquals("Test if the arraylist contains the added array",1,foodItemArr.size());
		
		foodItemArr.clear();
		//------------------------------------------------------------------------------------------------------------
		//if price less than limit
		//check if arraylist is empty at the beginning
		assertNotNull("Test if array is empty at start",foodItemArr);
		
		//add a new fooditem object to arraylist
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(1,"Chicken Rice",2));
		
		//check if arraylist does not contan new item 
		assertEquals("Test if the arraylist does not contan new item ",0,foodItemArr.size());
		
		foodItemArr.clear();
		//------------------------------------------------------------------------------------------------------------
		//If price is on the limit (boundary)
		//check if arraylist is empty at the beginning
		assertNotNull("Test if array is empty at start",foodItemArr);
		
		//add a new fooditem object to arraylist
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(1,"Chicken Rice",3));
		
		//check if arraylist does not contan new item 
		assertEquals("Test if the arraylist does not contan new item ",1,foodItemArr.size());
		
		foodItemArr.clear();
		//------------------------------------------------------------------------------------------------------------
		//error
		//check if arraylist is empty at the beginning
		assertNotNull("Test if array is empty at start",foodItemArr);
		
		//add a new fooditem object to arraylist
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(1,"Chicken Rice",17));
		
		//check if arraylist does not contan new item 
		assertEquals("Test if the arraylist does not contan new item ",0,foodItemArr.size());
		
	}
	@Test
	public void viewFoodItemTest() {
		foodItemArr.clear();
		//check if arraylist is empty at the beginning
		assertNotNull("Test if array is empty at start",foodItemArr);
		
		//add a new fooditem object to arraylist
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(1,"Chicken Rice",4));
		
		//check if arraylist contains new item that is added
		assertTrue(C206_CaseStudy.viewAllFoodItem(foodItemArr).contains("Chicken Rice"));
	}
	@Test
	public void deleteFoodItemTest() {
		foodItemArr.clear();
		//check if arraylist is empty at the beginning
		assertNotNull("Test if array is empty at start",foodItemArr);
		
		//add a new fooditem object to arraylist
		FoodItem fi = new FoodItem(1,"Chicken Rice",4);
		C206_CaseStudy.addFoodItem(foodItemArr,fi);
		
		//check if arraylist contains new item that is added
		C206_CaseStudy.deleteFoodItem(foodItemArr,1);
		assertEquals(foodItemArr.size(),0);
	}
	
	///Request Order Test Cases (Need to fix in CaseStudy) :|
	@Test
	public void viewRequestOrderTest() {
		
		//Check if arrayList is empty at the Beginning
		assertNotNull("Test that arrayList is empty", requestArr);
		
		//add new Request Order to arrayList
		C206_CaseStudy.addRequestOrder(requestArr, new RequestOrder(1,"Order1", "orderFood1"));
		
		//Test that requestOrder can be viewed in the list
		assertTrue(C206_CaseStudy.viewAllRequestOrder(requestArr).contains("Order1"));	
		
		//Test thet name of order can be viewed
		assertEquals("Order1", requestArr.get(0).getName());
		
		//Test the items in order can be viewed
		assertEquals("orderFood1", requestArr.get(0).getOrder());
		
	}
	
	@Test
	public void addRequestOrderTest() {
		requestArr.clear();
		//check if arraylist is empty at the beginning
		assertNotNull("Test if array is empty at start",requestArr);
		
		// Add to orderArr
		C206_CaseStudy.addRequestOrder(requestArr, reqOrder1);
		C206_CaseStudy.addRequestOrder(requestArr, reqOrder2);
		C206_CaseStudy.addRequestOrder(requestArr, reqOrder3);
		assertEquals("Test that requestArr arraylist size is 3?", 3, requestArr.size());
		
		// Test that order add is accurate
		assertSame("Test that reqOrder is added to the list?", reqOrder3, requestArr.get(2));
		
		//Test that items in the order added is displayed
		assertSame("order3", requestArr.get(2).getOrder());
		
	}
	
	@Test
	public void deleteRequestOrderTest() {
		requestArr.clear();
		
		//check that nothing can be deleted if nothing inside the list
		C206_CaseStudy.removeRequestOrder(requestArr, 1);
		assertEquals(0, requestArr.size());
		
		//add a new request object to arraylist
		C206_CaseStudy.addRequestOrder(requestArr, reqOrder1);
		C206_CaseStudy.addRequestOrder(requestArr, reqOrder2);
		C206_CaseStudy.addRequestOrder(requestArr, reqOrder3);
		
		//check if object can be deleted from list
		C206_CaseStudy.removeRequestOrder(requestArr, 1);
		assertEquals(2, requestArr.size());
		
		//Check that other objects are not affected by the delete
		assertNotNull(requestArr.get(1));
		
		//Test that the right item is deleted
		assertEquals(reqOrder2, requestArr.get(0));
		assertEquals(reqOrder3, requestArr.get(1));
		
	}
	
	
	//Promotion Left 
	@Test
	public void viewPromotion() {
		//Test array is no empty
		assertNotNull("Test foodItemArr is not empty",foodItemArr);
		
		//Test Food Item contains each instance of promotion
		for(int i = 0 ; i < foodItemArr.size(); i++) {
			assertNotNull(foodItemArr.get(i).getPromotionPrice());
		}
		
		//Test Promotion added to foodItem
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(1,"Chicken Rice",5));
		assertEquals(1, foodItemArr.get(0).getPromotionPrice());
		
		//Test new Item is indeed to promotion
		assertEquals("Chicken Rice", foodItemArr.get(0).getPromotionPrice());
		
	}

	public void addPromotionTest() {
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(1,"Chicken Rice",5));
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(2,"Chicken Noodle",7));
		C206_CaseStudy.addFoodItem(foodItemArr,new FoodItem(3,"Chicken Burger",4));
		
		//Test that promotion for id = 1 is added.
		C206_CaseStudy.addPromotion(foodItemArr, 1);
		assertEquals(3, foodItemArr.get(0).getPromotionPrice());
		
		//Test that other items are not affected
		assertNotNull(foodItemArr.get(1).getPromotionPrice());
		
		//Test that promotion price cannot drop below $3
		C206_CaseStudy.addPromotion(foodItemArr, 3);
		assertEquals(3, foodItemArr.get(0).getPromotionPrice());
		
		//Test that promotion cannot be added twice to same item
		C206_CaseStudy.addPromotion(foodItemArr, 3);
		assertEquals(3, foodItemArr.get(0).getPromotionPrice());
	}
	
	public void deletePromotion() {
		foodItemArr.clear();
		//check that nothing can be deleted if nothing inside the list
		assertNotNull("Test foodItem Array & promotion is not empty", foodItemArr);
		
		//Test promotion is added
		C206_CaseStudy.addPromotion(foodItemArr, 1);
		assertEquals(1, foodItemArr.get(0).getPromotionPrice());
		
		//Delete
		C206_CaseStudy.deletePromotion(foodItemArr);
		assertEquals(0, foodItemArr.get(0).getId());
		
	}
}
