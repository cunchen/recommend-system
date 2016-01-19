package com.cunchen.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cunchen.bean.BasicBean;
import com.cunchen.bean.HabitsBean;

/**
 * This class for reading training and test files.It can 
 * be suitable for Grouplens and other data sets.
 * @author wqd
 *
 */
public class ReaderFormat {
	List<BasicBean> lists;
	List<HabitsBean> formLists;
	
	public List<BasicBean> read (String filePath) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader in = new BufferedReader(
				new FileReader(filePath));
		String s;
		BasicBean basicBean = null;
		lists = new ArrayList<BasicBean>();
		while((s = in.readLine()) != null) {
//			System.out.println(s);
			String[] params = s.split("\t");
			
//			for (String string : params) {
//				System.out.println(string);
//			}
			
			basicBean = new BasicBean(params);
			lists.add(basicBean);
		}
		return lists;
	}
	
	//combine user log like | userID | habitID | ...
	//to userID and | habitID1 | habitID2 | habitID3 | ...
	public List<BasicBean> formateLogUser(String filePath) throws IOException {
		lists = this.read(filePath);
		int size = ((BasicBean)lists.get(lists.size()-1)).getInt(0);
		formLists = new LinkedList<HabitsBean>();
		HabitsBean row = null;
		for (BasicBean basicBean : lists) {
			if(formLists.size() == 0) {
				row = new HabitsBean(1);
				row.setId(basicBean.getInt(0));
				row.add(basicBean.getString(1));
				continue;
			}
			int pointer = binarySerch(formLists, row);
			if(pointer == -1) {
				row = new HabitsBean(basicBean.getInt(0));
			} else {
				row = formLists.get(pointer);
			}
			row.add(basicBean.getString(1));
		}
		return null;
	}
	
	//binary serch
	private int binarySerch(List<HabitsBean> lists, HabitsBean bean) {
		int start = 0;
		int end = lists.size();
		int pointer = (start + end) / 2;
		HabitsBean row = null;
		while(pointer > start && pointer < end) {
			row = lists.get(pointer);
			if(row.getId() == bean.getId()) {
				return row.getId();
			} else if(row.getId() > bean.getId()) {
				end = pointer;
			} else if(row.getId() < bean.getId()) {
				start = pointer;
			}
			pointer = (start + end + 1) / 2;
		}
		return -1;
	}
	
	
	// test
	public static void main(String[] args) {
		ReaderFormat readerFormat = new ReaderFormat();
		try {
			readerFormat.read("E:/WorkSpace/Input/ml-100k/u1.base");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
