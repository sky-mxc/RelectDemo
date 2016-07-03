package com.accp.entity;

public class Test {

	public static void main(String[] args) {

		
	}
	
	/**
	 * 获取类对象
	 *  
	 * @author mxc  
	 * @Date 2016年6月24日上午8:19:42
	 */
	public void test_Class(){
		try {
			//1.加载这个类 创建类实例
			Class clss = Class.forName("com.accp.entity.Dept");
			//2.通过这个类对象创建类实例
			Class cls= Dept.class;
			//3.根据类的对象 创建类实例
			Dept dept = new Dept();
			Class clz = dept.getClass();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
