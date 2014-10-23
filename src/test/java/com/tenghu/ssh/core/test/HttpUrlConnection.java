package com.tenghu.ssh.core.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.IdClass;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HttpUrlConnection {
	public static void main(String[] args) {
		
			try {
				URL url=new URL("http://api.36wu.com/Translate/GetTranslate?q=我是中国人，我爱我的国家&format=auto");
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				conn.setDoInput(true);
				conn.setDoOutput(true);
				conn.setRequestMethod("GET");//设置请求方式
				if(conn.getResponseCode()==200){//判断响应码
					//获取输入流
					InputStream in=conn.getInputStream();
					//创建缓冲流对象
					BufferedReader br=new BufferedReader(new InputStreamReader(in));
					String line=null;
					StringBuffer sb=new StringBuffer();
					while((line=br.readLine())!=null){
						sb.append(line);
					}
					System.out.println(sb.toString());
					JSONObject json=JSONObject.parseObject(sb.toString());
					System.out.println("状态码："+json.getInteger("status"));
					System.out.println(JSONObject.parseObject(sb.toString(), Base.class).getMessage());
					System.out.println((JSONObject.parseObject(sb.toString(),Base.class).getData().get(0)).getDst());
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (ProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
}
