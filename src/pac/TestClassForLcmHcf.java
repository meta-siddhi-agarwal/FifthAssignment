package pac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestClassForLcmHcf {
LcmHcf lcmHcfObject=new LcmHcf();



@Test
public void testCaseForLcm() {
	assertEquals(12,lcmHcfObject.computeLcm(4, 6, 1, 2));
	
	assertEquals(7,lcmHcfObject.computeLcm(7, 7, 1, 2));
	
	assertEquals(15,lcmHcfObject.computeLcm(1, 15, 1, 2));
	
	assertEquals(100,lcmHcfObject.computeLcm(1, 100, 1, 2));
	
	assertEquals(221,lcmHcfObject.computeLcm(13, 17, 1, 2));
	
	assertEquals(2000,lcmHcfObject.computeLcm(1000, 2000, 1, 2));
	
	assertEquals(1,lcmHcfObject.computeLcm(1, 1, 1, 2));
}
	
@Test
public void testCaseForHcf() {
	assertEquals(4,lcmHcfObject.computeHcf(8, 12, 8));
	
	assertEquals(12,lcmHcfObject.computeHcf(36,60,36));
	
	assertEquals(9,lcmHcfObject.computeHcf(9,9,9));
	
	assertEquals(1,lcmHcfObject.computeHcf(1, 20,1));
	
	assertEquals(1,lcmHcfObject.computeHcf(1,99,1));
	
	assertEquals(1,lcmHcfObject.computeHcf(13,17,13));
	
	assertEquals(1000,lcmHcfObject.computeHcf(1000,2000,1000));
	
	assertEquals(1,lcmHcfObject.computeHcf(1,1,1));
}


}
