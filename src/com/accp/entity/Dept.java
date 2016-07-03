package com.accp.entity;

import java.io.IOException;
import java.io.Serializable;

public class Dept implements Serializable {
	private Integer deptno;
	private String dname;
	private String loc;
	
	public Dept(String dname, String loc) {
		super();
		this.dname = dname;
		this.loc = loc;
	}
	public Dept(Integer deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String toString(){
		return "部门编号"+deptno+"\t部门名称"+dname+"\t"+"部门地址："+loc;
		
	}
	private void printName(String name){
		System.out.println(name);
		
	}
	public   void printLoc(String loc )throws IOException{
		System.out.println(loc);
	}
}
