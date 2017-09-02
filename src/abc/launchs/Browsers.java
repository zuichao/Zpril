package abc.launchs;

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
//				System.setProperty("webdriver.firefox.bin", "E:/selenium/firefox/firefox.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("閿熸彮璇ф嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熻娇浼欐嫹鑼敓鏂ゆ嫹閿熸枻鎷烽敓锟�?");
			}
			driver = new FirefoxDriver();
			
			//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�?
			driver.manage().window().maximize();
			
//			//閿熸枻鎷烽敓鐭揪鎷烽敓鑺傜殑鍖℃嫹榫嬮敓锟�?1000 閿熺搴︼綇鎷�500
//			Dimension d = new Dimension(1000, 500);
//			driver.manage().window().setSize(d);
//			
//			//閿熸枻鎷烽敓鐭揪鎷烽敓鑺傜鎷烽敓鏂ゆ嫹閿熺枼锛岄敓鏂ゆ嫹閿熼ズ锝忔嫹200 绾敓楗猴綇鎷�100
//			Point p = new Point(200, 100);
//			driver.manage().window().setPosition(p);
			break;
			
		case ie:
			try {
				System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("閿熸彮璇ф嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熻娇浼欐嫹鑼敓鏂ゆ嫹閿熸枻鎷烽敓锟�?");
			}
			driver = new InternetExplorerDriver();
			
			//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�?
			//driver.manage().window().maximize();
			
			//閿熸枻鎷烽敓鐭揪鎷烽敓鑺傜殑鍖℃嫹榫嬮敓锟�?800 閿熺搴︼綇鎷�800
			Dimension a = new Dimension(800, 800);
			driver.manage().window().setSize(a);
			
			//閿熸枻鎷烽敓鐭揪鎷烽敓鑺傜鎷烽敓鏂ゆ嫹閿熺枼锛岄敓鏂ゆ嫹閿熼ズ锝忔嫹800 绾敓楗猴綇鎷�800
			Point b = new Point(800, 800);
			driver.manage().window().setPosition(b);
			break;		
			
		case chrome:
			try {
				System.setProperty("webdriver.chrome.driver", "E:/selenium/chrome1/chromedriver.exe");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("閿熸彮璇ф嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熻娇浼欐嫹鑼敓鏂ゆ嫹閿熸枻鎷烽敓锟�?");
			}
			driver = new ChromeDriver();
			
			//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�?
			//driver.manage().window().maximize();
			
			//閿熸枻鎷烽敓鐭揪鎷烽敓鑺傜殑鍖℃嫹榫嬮敓锟�?800 閿熺搴︼綇鎷�800
			Dimension c = new Dimension(800, 800);
			driver.manage().window().setSize(c);
			
			//閿熸枻鎷烽敓鐭揪鎷烽敓鑺傜鎷烽敓鏂ゆ嫹閿熺枼锛岄敓鏂ゆ嫹閿熼ズ锝忔嫹800 绾敓楗猴綇鎷�800
			Point e = new Point(800, 800);
			driver.manage().window().setPosition(e);
			
			driver.manage().window().maximize();
			break;
		}
	}

}
