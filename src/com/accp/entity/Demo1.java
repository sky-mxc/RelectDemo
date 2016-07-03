package com.accp.entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * 
 * @Description: TODO 测试 反射机制
 * @author sky_mxc
 * @date 2016年4月25日
 */
public class Demo1 {

	public static void main(String[] args) {
		try {
			//1.加载这个类 创建类实例
			Class cls = Class.forName("com.accp.entity.Dept");
			//2.通过这个类对象创建类实例
			//Class cls= Dept.class;
			//3.根据类的对象 创建类实例
			//Dept dept = new Dept();
			//Class cls = dept.getClass();
			//获取这个实例的public构造函数数组
			Constructor[] constructors = cls.getConstructors();
			System.out.println("构造函数");
			for (Constructor constructor : constructors) {
				System.out.println("构造函数"+constructor);
			}
			Method [] methods = cls.getMethods();
			System.out.println("方法：");
			for (Method method : methods) {
				System.out.println("方法："+method);
			}
			System.out.println("属性（字段）");
			Field[] fields = cls.getFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			System.out.print("包名：");
			Package pack = cls.getPackage();
			System.out.println(pack);
			System.out.print("接口");
			Class[] interfaces = cls.getInterfaces();
			for (Class i : interfaces) {
				System.out.println(i);
			}
			System.out.println("父类"+cls.getSuperclass());
			Annotation[] annotations = cls.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println("注解："+annotation);
			}
 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
