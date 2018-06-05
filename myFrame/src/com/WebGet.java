package com;

public class WebGet extends Thread {
	
	private String URL;
	private String code;
	private Myframe myframe;
	private int type;
	
	public WebGet(String URL,String code,Myframe myframe,int type) {
		this.URL = URL;
		this.code = code;
		this.myframe = myframe;
		this.type = type;
		
	}
	public void run() {
		String returntxt;
		System.out.println("正在加载..");
		Myclass web = new Myclass();
		returntxt = web.GetWeb(URL,code);
		System.out.println(returntxt);
		if(type == 1)
			myframe.GetCallback(returntxt);
		System.out.println("加载完成..");
	}
}
