package com;
import java.awt.Dimension;
import java.awt.Toolkit;


public class App {

	int Framewide = 800,FrameHeight = 600;
	
	public static void main(String []arg)
	{
		
		new App();
		
	}
	
	public App() {
		
		
		
		
		
		
		

		Myframe frame = 	new Myframe();
		frame.setVisible(true);
		frame.setSize(Framewide, FrameHeight);
		frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-Framewide/2, Toolkit.getDefaultToolkit().getScreenSize().height/2-FrameHeight/2);
		/*
		String a = "<html>assas</html>\n<html>aasdasdssas</html>\n<html>ssdassas</html>";
		
		String []b = Myclass.GetMidstr(a, "<html>", "</html>");
		
				for(int i = 0 ;i < b.length;i++)
				{
					System.out.println(b[i]);
				}*/
	}
	
}
