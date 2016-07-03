package com.accp.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo3 {

	public static void main(String[] args) {
		invokeSetter("com.accp.entity.Dept","loc","String","三楼");
	}
	public static void invokeSetter(String className,String propName,String propType,String propValue){
		try {
			Class cls = Class.forName(className);
			System.out.println("load Class succeed;");
			Object obj = cls.newInstance();
			System.out.println("instance Object succeed;");
			Method method = cls.getMethod("set"+propName.substring(0,1).toUpperCase()+propName.substring(1), propValue.getClass());
			System.out.println("instance method succeed;");
			method.invoke(obj, propValue);
			System.out.println("invoke method succeed;");
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void test_Method() {
		try {
			
			
			Class clz = Class.forName("com.accp.entity.Dept");
			Method[] methods = clz.getMethods();
			for (Method method : methods) {
				System.out.println("........................."+method+"....Modifier: "+method.getModifiers()+" ..."+Modifier.toString(method.getModifiers()));
				
				//Modifier：
				System.out.print(Modifier.toString(method.getModifiers())+"  ");
				//ReturnType
				System.out.print(method.getReturnType().getName()+"  ");
				//MethodName
				System.out.print(method.getName()+"(  ");
				//ParameterType
				if(method.getParameterTypes().length>0){
					//遍历 参数数组
					for (Class param : method.getParameterTypes()) {
						System.out.print(param.getName()+"  ");
					}
				}
				
				System.out.print(")");
				//ExceptionType
				if (method.getExceptionTypes().length>0) {
					System.out.print(" throws ");
					//遍历抛出的异常数组
					for (Class exception : method.getExceptionTypes()) {
						System.out.println(exception.getName());
					}
				}
				System.out.println();
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Description: TODO 构造函数信息
	 * @param    
	 * @return void  
	 * @throws
	 * @author sky_mxc
	 * @date 2016年4月25日
	 */
	private static void test_ConstructorInfo() {
		try {
			
			
			Class clz = Class.forName("com.accp.entity.Dept");
			Constructor[] constructors = clz.getConstructors();
			System.out.println("Constructor...:");
			for (Constructor constructor : constructors) {
				//Modifier
				System.out.print(" : "+Modifier.toString(constructor.getModifiers()));
				//返回了类的完全限定名，是不是意味着Constructor中的name实际也是返回值
				//ConstructorName
				System.out.print(""+constructor.getName());
				System.out.print("(");
				//遍历 构造函数的参数
				if (constructor.getParameterTypes().length>0) {
					for (Class param : constructor.getParameterTypes()) {
						System.out.print(param.getName()+" ");
					}
				}
				System.out.println(")");
				System.out.println();
				
			}
			//通过构造函数直接实例化出对象  无法通过私有构造函数 创建对象
			Dept dept = (Dept) constructors[0].newInstance();
			dept.setDeptno(900);
			System.out.println("0 "+dept);
			Dept dept1 = (Dept) constructors[1].newInstance(901,"就业部","一楼");
			System.out.println("1 "+dept1);
			Dept dept2 = (Dept) constructors[2].newInstance("事业部","二楼");
			
			System.out.println("2 "+dept2);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Description: TODO 获取属性信息
	 * @param    
	 * @return void  
	 * @throws
	 * @author sky_mxc
	 * @date 2016年4月25日
	 */
	private static void test_FieldInfo() {
		try {
			Class cls = Class.forName("com.accp.entity.Dept");
			//获取部门类定义的字段    getFields 公有的字段   ,.getDeclaredFields全部字段
			Field[] fields = cls.getDeclaredFields();
			//遍历显示属性信息
			System.out.println("field  ..:");
			for (Field field : fields) {
				//System.out.println("\t\tModifier:"+Modifier.toString(field.getModifiers())+",\tType :"+field.getType().getName()+",\tName :"+field.getName()+"\n");
				System.out.println(" Modifier: "+Modifier.toString(field.getModifiers()));
				System.out.println(" Type: " +field.getType().getName());
				System.out.println(" Name: "+field.getName());
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 *  
	 * @Description: TODO 动态构建 对象实例
	 * @param    
	 * @return void  
	 * @throws
	 * @author sky_mxc
	 * @date 2016年4月25日
	 */
	private static void test_Constructor_instance() {
		try {
			
			
			//1.加载这个类 创建类实例
			Class cls = Class.forName("com.accp.entity.Dept");
			Object object= cls.newInstance();//调用这个类的无餐构造函数
			System.out.println(object);
			//调用有参构造函数 构建实例
			Constructor constructor = cls.getConstructor(Integer.class,String.class,String.class);
			Object obj1 = constructor.newInstance(12,"就业部","三楼");
			
			System.out.println(obj1);
 		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
