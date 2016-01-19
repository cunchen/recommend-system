package com.cunchen.bean;

/**
 * 
 * @author wqd
 *
 */
public class HabitsBean extends BasicBean {
	private int id ;

	//get the ID
	public int getId() {
		return id;
	}

	//set the ID
	public void setId(int id) {
		this.id = id;
	}
	
	//default id is -1,it means the id hadn't been evaluated
	public HabitsBean(int n) {
		this(-1, n);
	}
	
	public HabitsBean(int id, int n) {
		super(n);
		this.id = id;
	}
}
