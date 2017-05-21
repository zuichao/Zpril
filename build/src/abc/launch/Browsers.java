package abc.launch;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {

	public WebDriver driver = null;
	
	public Browsers (BrowsersType browserstype){
		switch (browserstype) {
		case firefox:
			try {
				System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("找不到浏览器的位置！！！");
			}
			driver = new FirefoxDriver();
			
			//窗口最大化
			driver.manage().window().maximize();
			
//			//设置窗口的宽度：1000 高度：500
//			Dimension d = new Dimension(1000, 500);
//			driver.manage().window().setSize(d);
//			
//			//设置窗口的坐标，经度：200 纬度：100
//			Point p = new Point(200, 100);
//			driver.manage().window().setPosition(p);
			break;
			
		case ie:
			try {
				System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("找不到浏览器的位置！！！");
			}
			driver = new InternetExplorerDriver();
			
			//窗口最大化
			//driver.manage().window().maximize();
			
			//设置窗口的宽度：800 高度：800
			Dimension a = new Dimension(800, 800);
			driver.manage().window().setSize(a);
			
			//设置窗口的坐标，经度：800 纬度：800
			Point b = new Point(800, 800);
			driver.manage().window().setPosition(b);
			break;		
			
		case chrome:
			try {
				System.setProperty("webdriver.chrome.driver", "D:/Chrome/Chrome/Application/chromedriver.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("找不到浏览器的位置！！！");
			}
			driver = new ChromeDriver();
			
			//窗口最大化
			//driver.manage().window().maximize();
			
			//设置窗口的宽度：800 高度：800
			Dimension c = new Dimension(800, 800);
			driver.manage().window().setSize(c);
			
			//设置窗口的坐标，经度：800 纬度：800
			Point e = new Point(800, 800);
			driver.manage().window().setPosition(e);
			break;
		}
	}

}
