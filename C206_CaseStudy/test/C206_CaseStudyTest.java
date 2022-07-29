import static org.junit.Assert.*;

import java.util.ArrayList;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	// prepare test data
	private ArrayList<Stall> stallArr;
	private ArrayList<FoodItem> foodItemArr;
	private ArrayList<RequestOrder> requestArr;
	private ArrayList<Order> orderArr;
			
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
		assertEquals("Test if that Camcorder arraylist size is 1?",1, stallArr.size());
		
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

}
