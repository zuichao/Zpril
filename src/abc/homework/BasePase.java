package abc.homework;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePase {
	
//公共页面
	
	private WebDriver driver;
	private DBOp db ;
	private Map<String, String> sf = new HashMap();
	
	
	//构造函数
	public BasePase(WebDriver driver,String tablename){
		this.driver=driver;
		
		db = new DBOp(tablename);
		db.conn(System.getProperty("user.dir")+"/src/abc/homework/qqmailDB.sqlite");
	}
	

	public WebElement getLoc(String loc){
		WebElement we = null;
		
		if(db.getXpath(loc)!=null){
			try{
				we = this.driver.findElement(By.xpath(db.getXpath(loc)));
			}catch (Exception e) {
				if(db.getCss(loc)!=null)
					we = this.driver.findElement(By.cssSelector(db.getCss(loc)));
			}
		}
		else {
			we = this.driver.findElement(By.cssSelector(db.getCss(loc)));
		}
		
		return we;
		
	}
	
	public String getLocvalue(String loc){
		sf.clear();
		
		if (db.getXpath(loc)!=null) {
			sf.put(loc, db.getXpath(loc));
		}
		else {
			sf.put(loc, db.getCss(loc));
		}
		return sf.get(loc);
	}
}

