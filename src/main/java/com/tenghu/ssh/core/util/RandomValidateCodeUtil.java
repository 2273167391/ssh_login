package com.tenghu.ssh.core.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tenghu.ssh.core.common.DictKeys;


/**
 * 随机验证码工具类
 * @author Arvin
 *
 */
public class RandomValidateCodeUtil {
	private RandomValidateCodeUtil(){}
	
	private static int img_width=100;//图片宽度
	private static int img_height=30;//图片高度
	private static int interference_line=30;//干扰线
	private static int interference_point=100;//干扰点
	private static int random_num=4;//产生随机数个数
	private static Random random=new Random();//实例化随机数类
	private static String random_str="123456789abcdefghijkmnpqrstuvwxyz";
	
	/**
	 * 获取字体
	 * @return
	 */
	private static Font getFont(){
		return new Font("Fixedsys", Font.BOLD, 28);
	}
	
	/**
	 * 获取颜色
	 * @return
	 */
	private static Color getColor(){
		return new Color(random.nextInt(155), random.nextInt(150), random.nextInt(150));
	}
	
	/**
	 * 获取验证码图片
	 * @param request
	 * @param response
	 */
	public static void getRandom(HttpServletRequest request,HttpServletResponse response){
		BufferedImage image=new BufferedImage(img_width, img_height, BufferedImage.TYPE_INT_BGR);//创建图片缓冲类
		Graphics g=image.getGraphics();
		g.fillRect(0, 0, img_width, img_height);
		//绘制干扰线
		for(int i=0;i<interference_line;i++){
			drawLine(g);
		}
		//绘制干扰点
		for(int i=0;i<interference_point;i++){
			drawPoint(g);
		}
		//绘制验证码
		String randomStr="";
		for(int i=0;i<random_num;i++){
			randomStr+=drawFont(g, i);
		}
		//将验证码设置到Session中
		request.getSession().setAttribute(DictKeys.RANDOM_CODE_STR, randomStr);
		g.dispose();
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 绘制字体
	 * @param g
	 * @param i
	 */
	private static String drawFont(Graphics g,int i){
		g.setFont(getFont());//设置字体
		g.setColor(getColor());//设置颜色
		String rand=getRandomStr(random.nextInt(random_str.length()));//获取单个随机字符串
		g.drawString(rand, 28*i,25);
		return rand;
	}
	
	/**
	 * 绘制干扰线
	 * @param g
	 */
	private static void drawLine(Graphics g){
		g.setColor(getColor());//设置颜色
		int x=random.nextInt(img_width);
		int y=random.nextInt(img_height);
		int x1=random.nextInt(13);
		int y1=random.nextInt(15);
		g.drawLine(x, y, x+x1, y+y1);
	}
	
	/**
	 * 绘制干扰点
	 * @param g
	 */
	private static void drawPoint(Graphics g){
		g.setColor(getColor());//设置颜色
		int x=random.nextInt(img_width);
		int y=random.nextInt(img_height);
		g.fillOval(x, y, 2, 2);
	}
	
	/**
	 * 获取随机一个字符
	 * @param i
	 * @return
	 */
	private static String getRandomStr(int i){
		return String.valueOf(random_str.charAt(i));
	}
}
