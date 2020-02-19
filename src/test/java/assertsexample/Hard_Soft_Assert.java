package assertsexample;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hard_Soft_Assert {

	
	@Test(enabled = false)
	public void hardAssert() 
	{
		System.out.println("Am hard assert");
		Assert.assertEquals("Bala", "dileep");
		System.out.println("End of Testcase");
	}
	
	@Test
	public void softAssert() 
	{
		System.out.println("Am Soft Assert");
		SoftAssert sAssert =new SoftAssert();
		sAssert.assertEquals("Bala", "Dileep"); //fail
		sAssert.assertEquals("Bala", "Bala"); //pass
 		System.out.println("End of Testcases");
		
		sAssert.assertAll();
		
		
		
	}
	
}
