package com.cunchen.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * A row of data sets describes in witch the parameters are included.
 * 
 * @author wqd 2016/01/18
 */
public class BasicBean {
	private List<String> parameters;
//	private int num;
	private boolean tableHead;

	//Default constructor,the row set 5 floders and it isn't a table head
//	protected BasicBean() {
//		this(5);
//	}
	
//	///Default constructor,the row set n floders and it isn't a table head
//	public BasicBean(int n) {
//		this(false, 5);
//	}
	
	///Default constructor,the row set n floders and is or not a table head
	public BasicBean(boolean head) {
		parameters = new ArrayList<String>();
		this.tableHead = head;
	}
	
	//Default constructor,the row set table head and how much the row 
	//set is defined by the variable parameters,it isn't a table head
	public BasicBean(String... strings) {
		this(false, strings);
	}

	//Default constructor,the row set table head and how much the row 
	//set is defined by the variable parameters and is or not a table head
	public BasicBean(boolean head, String... strings) {
		parameters = new ArrayList<String>();
		for(String string : strings) {
			parameters.add(string);
		}
//		this.num = parameters.size();
		this.tableHead = head;
	}
	
	public int add(String param) {
		parameters.add(param);
		return this.getSize();
	}
	
	//replace a parameter value pointed to a new value
	//If success,return true.If not,return false.
	public boolean set(int index, String param) {
		if(index < this.getSize())
			parameters.set(index, param);
		else
			return false;
		return true;
	}
	
	//Get the head.If it has table head,return ture.
	//If not,return flase;
	public boolean isHead() {
		return tableHead;
	}
	
	//Override toString()
	public String toString() {
		StringBuilder str = new StringBuilder(" ");
		int len = 1;
		for (String string : parameters) {
			str.append("\t|" + string);
			if(len++ % 20 == 0)
				str.append("\n");
		}
		return str.toString();
	}
	
	//Get number of parameters
	public int getSize() {
		return parameters.size();
	}
	
	//Get array
	public List<String> getArray() {
		return this.parameters;
	}
	
	//Get ID of a set
	public int getId() {
		return this.getInt(0);
	}
	
	public String getString(int index) {
		return parameters.get(index);
	}
	
	public int getInt(int index) {
		return Integer.valueOf(parameters.get(index));
	}
	
	public boolean getBoolean(int index) {
		return Boolean.valueOf(parameters.get(index));
	}
	
	public float getFloat(int index) {
		return Float.valueOf(parameters.get(index));
	}
}
