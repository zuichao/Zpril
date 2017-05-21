package abc.interfaces;

public interface Elements {
	String xiayiye = "//a[following-sibling::a[contains(text(),'跳转')] and @id='nextpage1']";
	String shoujianxiang = "//div[contains(text(),'收件箱')]";
	//动态Xpath定位
	String mingcheng = String.format("//a[contains(text(),'%2$s')]", "醉嘲","C罗","jack","Miss");
}
