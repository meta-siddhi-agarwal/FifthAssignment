package pac;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestClassForSearch {
	
	Search searchObject=new Search();
	
	@Test
	public void testCaseForLinearSearch() {
		int arrayInput1[]= {10,20,30,40,50};
		assertEquals(2, searchObject.linearSearch(arrayInput1, 30, 0));
		
		int arrayInput2[]= {11,22,33,44};
		assertEquals(-1, searchObject.linearSearch(arrayInput2, 99, 0));
		
		int arrayInput3[]= {7,2,3,7,5};
		assertEquals(0, searchObject.linearSearch(arrayInput3, 7, 0));
		
		int arrayInput4[]= {};
		assertEquals(-1, searchObject.linearSearch(arrayInput4, 10, 0));
		
		int arrayInput5[]= {-5,-10,-15};
		assertEquals(1, searchObject.linearSearch(arrayInput5, -10, 0));
		
	}
	
	@Test
	public void testCaseForBinarySearch() {
		int arrayInput1[]= {10,20,30,40,50};
		assertEquals(2, searchObject.binarySearch(arrayInput1, 30, 0,4));
		
		int arrayInput2[]= {5,10,15,20};
		assertEquals(0, searchObject.binarySearch(arrayInput2, 5, 0,3));
		
		int arrayInput3[]= {10,20,30,40};
		assertEquals(-1, searchObject.binarySearch(arrayInput3, 99, 0,3));
		
		int arrayInput4[]= {};
		assertEquals(-1, searchObject.binarySearch(arrayInput4, 10, 0,-1));
		
		int arrayInput5[]= {1,2,3,4};
		assertEquals(-1, searchObject.binarySearch(arrayInput5, -10, 0,3));
		
	}

}
