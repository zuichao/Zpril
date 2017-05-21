package abc.testdata;

import java.beans.Statement;
import java.sql.*;

public class DBOp {
	
	private Statement stat = null;
	private ResultSet rsq = null;
	private String tablename = null;
	
	public DBOp(String tablename){
		this.tablename = tablename;
	}
	
	public void conn(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"/tools/mylocator.sqlite");
			stat = (Statement) conn.createStatement();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	
	public String getLocatorXpath(String locatorname){
		String xpath = null;
		try{
			rsq = ((java.sql.Statement) stat).executeQuery("select * from "+tablename+"where webElementName = '"+locatorname+"';");
			while(rsq.next()){
				
				xpath = rsq.getString("Xpath");
				
			}
			rsq.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return xpath;
	}
	
	
	public String getLocatorCSS(String locatorname){
		String css = null;
		try{
			rsq = ((java.sql.Statement) stat).executeQuery("select * from "+tablename+"where WebElementName = '"+locatorname+"';");
			while(rsq.next()){
				
				css = rsq.getString("CSS");
				
			}
			rsq.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return css;	
	}
	
	
	public static void main(String[] args){
		DBOp test = new DBOp("LoginPage");
		test.conn();
		System.out.println(test.getLocatorXpath("UserName"));
		//System.out.println(test.getLocatorCSS("Password"));
	}
}

