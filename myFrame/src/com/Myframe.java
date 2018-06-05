package com;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.io.*;
import java.net.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Myframe extends JFrame {
	
	private JTextField textField;
	private String [] seach;
	private String [] name;
	private String []link;
	private String []img;
	private ActionListener  Listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			JButton button = (JButton)arg0.getSource();

			int index = Integer.valueOf(button.getActionCommand());
			
			
			
			JOptionPane.showMessageDialog(new JFrame().getContentPane(), "视频详情:"+ link[index] + "\n" + "图片:" + img[index] , "系统信息", JOptionPane.WARNING_MESSAGE); 
			
		}
	};
	
	private int size = 0;
	
	private JButton []Button = new JButton[0];
	public Myframe() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(154, 21, 279, 35);
		getContentPane().add(textField);
		textField.setColumns(10);
		Myframe returnclass = this;
		
		JButton btnNewButton = new JButton("\u641C\u7D22");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				WebGet x;
				try {
					x = new WebGet("http://so.kan.2345.com/search_"+ URLDecoder.decode(textField.getText(),"UTF-8") + "/" ,"gb2312",returnclass,1);
					x.start();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(471, 21, 160, 35);
		getContentPane().add(btnNewButton);
		
		
		
		
	}
	
	
public void GetCallback(String Scourcecode)
{
		
			seach = Myclass.GetMidstr(Scourcecode, "<div class=\"posterPlaceholder\">", "<div class=\"clear\"></div>");
	
			name = new String [seach.length];
			link = new String[seach.length];
			img = new String[seach.length];
			System.gc();
			
			
			int Ypot = 70;
					
			
			for(int i = 0 ;i < seach.length;i++)
			{
				
				if(i+1 > size)
				{
					JButton [] tmp = new JButton[seach.length];
					System.arraycopy(Button, 0, tmp, 0, Button.length);
					Button = tmp;
					Button[i] = new JButton();
					Button[i].addActionListener(Listener);
					size ++;
					
				}

				name[i] = Myclass.GetMidstr2(seach[i],"title=\"","\" width=\"180\" height=");
				link[i] = Myclass.GetMidstr2(seach[i],"<h2><a href=\"","\" target");
				img[i] = "http://" + Myclass.GetMidstr2(seach[i],"data-src=\"//","\" alt=\"");
				System.out.println("名称："+ name[i] + "|||链接：" +link[i] + "|||图片："+img[i]);
				getContentPane().add(Button[i]);
				Button[i].setLocation(20, Ypot);
				Button[i].setSize(200, 30);
				Button[i].setText(name[i]);
				Button[i].setVisible(true);
				Button[i].setActionCommand(""+i);
				Ypot = Ypot + 30+10;
			}
		
	}
}



