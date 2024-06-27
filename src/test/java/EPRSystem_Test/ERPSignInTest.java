package EPRSystem_Test;

import java.io.IOException;

import org.testng.annotations.Test;

import EPRSystem.AddSalesDetail;
import EPRSystem.ERPSignIn;

public class ERPSignInTest extends BaseTest{
	@Test
	public void test() throws InterruptedException, IOException {
		
		String userName = "test_adarshagencies9@gmail.com";
		String password = "Test@1234";
		int otp = 752819;
		
		ERPSignIn signIn = new ERPSignIn(driver);	
		signIn.erpSignIn(userName, password, otp);
		Thread.sleep(15000);
	}
}
