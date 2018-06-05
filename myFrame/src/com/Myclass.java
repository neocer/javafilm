package com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import jdk.incubator.http.HttpClient;
/**
 * 通过URL读取页面内容
 * */

public class Myclass {

   public static String GetWeb(String Url,String Code)
   {
	   URL url;

       int responsecode;

       HttpURLConnection urlConnection;

       BufferedReader reader;

       String line;
       String Returndata = new String("");
       

       try{
           url=new URL(Url);
           urlConnection = (HttpURLConnection)url.openConnection();
           responsecode=urlConnection.getResponseCode();
           if(responsecode==200){

               reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),Code));

               while((line=reader.readLine())!=null){

            	   Returndata = Returndata + "\n" + line;
               }

           }

           else{

               System.out.println("获取不到网页的源码，服务器响应代码为："+responsecode);

           }

       }

       catch(Exception e){

           System.out.println("获取不到网页的源码,出现异常："+e);

       }
       
       return Returndata;
       
   }
   
   
   public static String[] GetMidstr(String text,String left,String right) {

	   String result[] = new String[0];
	   while(text.indexOf(left, 0) !=- 1 && text.indexOf(right, 0) !=- 1 && text.indexOf(text, 0) < text.indexOf(right, 0)  )
	   {
		   int lint = text.indexOf(left, 0);
		   int rint =  text.indexOf(right,lint);
		   String tmp[] =  new String[result.length + 1];
		   System.arraycopy(result, 0, tmp, 0, result.length);
		   tmp[result.length] = text.substring(lint+ left.length(), rint);

		   result= tmp;
		   text = text.substring(rint+right.length(), text.length());
		   
	   }
	   return result;
	   
   }
   
   public static String GetMidstr2(String text,String left,String right) {

	  
		   int lint = text.indexOf(left, 0);
		   int rint =  text.indexOf(right,lint);
		   String result = text.substring(lint+ left.length(), rint);
		   return result;
		   
		
	   
   }
   
   
}