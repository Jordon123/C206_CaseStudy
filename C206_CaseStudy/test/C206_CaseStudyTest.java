import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	// prepare test data
	private ArrayList<Stall> stallArr;
	private ArrayList<FoodItem> foodItemArr;
	private ArrayList<RequestOrder> requestArr;
			
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
	
	
	@Before
	public void setUp() throws Exception {
		
		stall1 = new Stall(1, "stall1", LocalDate.of(2020,10,3),"10am","Western", "Jordon");
		
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
		
	}

}
