package abc.testdatas;

import java.sql.*;

public class DBOp {
	
	private Statement stat = null;
	private ResultSet rsq   = null;
	private String tablename = null;
	
	public DBOp(String tablename){
		this.tablename = tablename;
	}
    
	public void conn(){
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"/tools/mylocator.sqlite");
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String  getXpath(String locatorname){
		String xpath = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 

				xpath = rsq.getString("Xpath");
				

				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xpath;
	}
	
	
	public String getCss(String locatorname){
		String css = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 

				
				css=rsq.getString("Css");

				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return css;
	}
	
	
	public String getValues(String locatorname){
		String values = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 

				
				values=rsq.getString("Values");

				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return values;
	}
	
	
	public static void main(String[] args) {
		DBOp test = new DBOp("LoginPage1");
		test.conn();
		System.out.println(test.getXpath( "IDpassword"));
		System.out.println(test.getCss( "Submit"));
		System.out.println(test.getValues("BaseUrl"));
		
	}
	
	
	
}