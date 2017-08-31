package abc;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import abc.launch.Browsers;
import abc.launch.BrowsersType;

public class TestWindows {
	
//处理浏览器弹出的新窗口
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod(){
		Browsers browsers = new Browsers(BrowsersType.firefox);
		this.driver = browsers.driver;
		this.driver.get("http://www.hao123.com/");
	}
	
	@AfterMethod
	public void afterMethod(){
		this.driver.quit();
	}
	
	@Test
	public void windows()throws Exception{
			
		WebDriver newWindow = null;
		//获取当前页面句柄
		String current_handles = this.driver.getWindowHandle();
		//点击“百度链接”
		this.driver.findElement(By.xpath("//*[@data-title='百度']")).click();
		//接下来回有新的窗口打开，获取所有窗口的句柄
		Set<String> all_handles = this.driver.getWindowHandles();
		//循环判断，把当前句柄从所有句柄中移除，剩下的就是你想要的新窗口
		Iterator<String> it = all_handles.iterator();
		while (it.hasNext()) {
			if (current_handles == it.next()) continue;
			//跳入新窗口，并获得新窗口的driver - newWindow
			newWindow = this.driver.switchTo().window(it.next());
		}
		
		//接下来在新页面进行操作，也就是百度首页，我们输入一个Java关键字进行搜索
		Thread.sleep(5000);
		WebElement baidu_keyword = newWindow.findElement(By.id("kw"));
		baidu_keyword.sendKeys("java");
		Thread.sleep(1000);
		//关闭当前窗口，主要使用close而不是quite
		newWindow.close();
		//返回到当前页面
		this.driver.switchTo().window(current_handles);
		//输出当前页面的URL
		System.out.println(this.driver.getCurrentUrl());
	}
	
}	
/*此方法是：
 * 穷举所有的窗口的titlename值，
 * 循环-判断窗口中是否包含指定的titlename值，
 * 如包含跳出循环-跳入此window，
 * 不包含，继续循环判断窗口的titlename值。
 */
	/*public void toSpecificWindow(){
		Set<String> handles = driver.getWindowHandles();
		String titlename;
		for(String handle:handles){
			titlename = driver.switchTo().window(handle).getTitle();
		if(titlename.contains("java_百度搜索"))cnblogs.com 
			break;
		}
	}

}*/
