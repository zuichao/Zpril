package abc;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

public class TestDownLoad {
  @Test
  public void downLoad() throws Exception{
	  
	  try{
		  Runtime.getRuntime().exec(System.getProperty("user.dir")+"/tools/download.exe");
		  Thread.sleep(5000);
	  }catch(IOException e){
		  e.printStackTrace();
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
