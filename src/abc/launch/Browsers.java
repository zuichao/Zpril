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
//				System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
				System.setProperty("webdriver.firefox.bin", "E:/selenium/firefox/firefox.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("锟揭诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟轿伙拷茫锟斤拷锟斤拷锟�");
			}
			driver = new FirefoxDriver();
			
			//锟斤拷锟斤拷锟斤拷锟�
			driver.manage().window().maximize();
			
//			//锟斤拷锟矫达拷锟节的匡拷龋锟�1000 锟竭度ｏ拷500
//			Dimension d = new Dimension(1000, 500);
//			driver.manage().window().setSize(d);
//			
//			//锟斤拷锟矫达拷锟节碉拷锟斤拷锟疥，锟斤拷锟饺ｏ拷200 纬锟饺ｏ拷100
//			Point p = new Point(200, 100);
//			driver.manage().window().setPosition(p);
			break;
			
		case ie:
			try {
				System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("锟揭诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟轿伙拷茫锟斤拷锟斤拷锟�");
			}
			driver = new InternetExplorerDriver();
			
			//锟斤拷锟斤拷锟斤拷锟�
			//driver.manage().window().maximize();
			
			//锟斤拷锟矫达拷锟节的匡拷龋锟�800 锟竭度ｏ拷800
			Dimension a = new Dimension(800, 800);
			driver.manage().window().setSize(a);
			
			//锟斤拷锟矫达拷锟节碉拷锟斤拷锟疥，锟斤拷锟饺ｏ拷800 纬锟饺ｏ拷800
			Point b = new Point(800, 800);
			driver.manage().window().setPosition(b);
			break;		
			
		case chrome:
			try {
				System.setProperty("webdriver.chrome.driver", "E:/selenium/chrome1/chromedriver.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("锟揭诧拷锟斤拷锟斤拷锟斤拷锟斤拷锟轿伙拷茫锟斤拷锟斤拷锟�");
			}
			driver = new ChromeDriver();
			
			//锟斤拷锟斤拷锟斤拷锟�
			//driver.manage().window().maximize();
			
			//锟斤拷锟矫达拷锟节的匡拷龋锟�800 锟竭度ｏ拷800
			Dimension c = new Dimension(800, 800);
			driver.manage().window().setSize(c);
			
			//锟斤拷锟矫达拷锟节碉拷锟斤拷锟疥，锟斤拷锟饺ｏ拷800 纬锟饺ｏ拷800
			Point e = new Point(800, 800);
			driver.manage().window().setPosition(e);
			
			driver.manage().window().maximize();
			break;
		}
	}

}
