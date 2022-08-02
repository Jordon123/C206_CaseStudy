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
		
		//Test that there is a ArrayList to add to.
		assertNotNull("Test if there is valid Stall arraylist to add to", stallArr);
		
		//Test that stalls can be add into the ArrayList.
		C206_CaseStudy.addStall(stallArr, stall1);
		assertEquals("Test that order arraylist size is 1?", 1, stallArr.size());

		
		//Test that the stall added into the Array contains all the right information.
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
		
		//Test that ArrayList will contain MAX 10 Stalls only.
		C206_CaseStudy.addStall(stallArr, stall11);
		assertEquals("Test if that Stall arraylist size is 10?",10, stallArr.size());
		
	}
	
	@Test
	public void deleteStallTest() {
		
		assertNotNull("Test if there is valid Stall arraylist to add to", stallArr);
		
		//Test that delete function would work.
		C206_CaseStudy.addStall(stallArr, stall1);
		C206_CaseStudy.deleteStall(stallArr, 1);	
		assertEquals("Test if that Stall arraylist size is 0?",0, stallArr.size());
		
		//Test that delete function would delete the right one
		C206_CaseStudy.addStall(stallArr, stall1);
		C206_CaseStudy.deleteStall(stallArr, 2);	
		assertEquals("Test if that Stall arraylist size is 1?",1, stallArr.size());
		
		//Clear the List
		stallArr.clear();
		
		//Test that only 1 stall is deleted
		C206_CaseStudy.addStall(stallArr, stall1);
		C206_CaseStudy.addStall(stallArr, stall2);
		C206_CaseStudy.deleteStall(stallArr, 2);	
		assertEquals("Test if that Stall arraylist size is 1?",1, stallArr.size());
	}
	
		@Test
	public void viewStallTest() {
		
		//test that nothing can be view if id is wrong.//error condition
		String checkStalls = C206_CaseStudy.viewStall(stallArr, 1);
		String testOutput2 = "";
		assertEquals(testOutput2, checkStalls);

		C206_CaseStudy.addStall(stallArr, stall1);
		
		//test if the expected output string same as the stall in the arrayList //normal
		String testOutput = "";
		testOutput = String.format("%-5d %-15s %-15s %-10s %-15s %-10s\n",1, "stall1", LocalDate.of(2020,10,3),"10am","Western", "Jordon");			
		assertEquals(testOutput, C206_CaseStudy.viewStall(stallArr, 1));
		
		//test that only 1 item will be displayed when viewStall is used
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
		
		//test that only cannot view stalls outside the max range
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
		
		//The item just added is as same as the first item of the list
		assertSame("Test that order is added same as 1st item of the list?", order1, orderArr.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addOrder(orderArr, order2);
		C206_CaseStudy.addOrder(orderArr, order3);
		assertEquals("Test that order arraylist size is 3?", 3, orderArr.size());
		assertSame("Test that order is added same as 3rd item of the list?", order3, orderArr.get(2));
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
		C206_CaseStudy.deleteFoodItem(foodItemArr,fi);
		assertEquals(foodItemArr.size(),0);
	}
	
	///Request Order Test Cases (Need to fix in CaseStudy) :|
	@Test
	public void viewRequestOrderTest() {
		
		//Check if arrayList is empty at the Beginning
		assertNotNull("Test that arrayList is empty", requestArr);
		
		//add new Request Order to arrayList
		C206_CaseStudy.addRequestOrder(requestArr, new RequestOrder(1,"Order1", "orderFood1"));
		
		//Check requestOrder
		assertTrue(C206_CaseStudy.viewAllRequestOrder(requestArr).contains("Order1"));	
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
		assertSame("Test that reqOrder is added to the list?", reqOrder3, requestArr.get(2));
	}
	
	@Test
	public void deleteRequestOrderTest() {
		requestArr.clear();
		//check if arraylist is empty at the beginning
		assertNotNull("Test if array is empty at start",requestArr);
		
		//add a new request object to arraylist
		C206_CaseStudy.addRequestOrder(requestArr, reqOrder1);
		assertEquals("Test that requestArr arraylist size is 1?", 1, requestArr.size());
		
		
		//check if arraylist contains new item that is added
		assertEquals(requestArr.size(), 1);
	}
	
	
	//Promotion Left 
	@Test
	public void viewPromotion() {
//		//check if arraylist is empty at the beginning
//		assertNotNull("Test if array is empty at start",foodItemArr);
//		
//		for(FoodItem fi : foodItemArr) {
//			if(fi.isPromotion()) {
//				assertTrue(C206_CaseStudy.viewAllFoodItem(foodItemArr).contains((CharSequence) foodItemArr.get(0)));
//			}
//		}
	}
	
	public void addPromotion() {
		
	}
	
	public void deletePromotion() {
		
	}
}
