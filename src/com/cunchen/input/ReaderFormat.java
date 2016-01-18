package com.cunchen.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cunchen.bean.BasicBean;

/**
 * This class for reading training and test files.It can 
 * be suitable for Grouplens and other data sets.
 * @author wqd
 *
 */
public class ReaderFormat {
	List<BasicBean> lists;
	List<BasicBean> formLists;
	
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
	//to | habitID1 | habitID2 | habitID3 | ... , userID is replaced by index placement 
	public List<BasicBean> formateLogUser(String filePath) throws IOException {
		lists = this.read(filePath);
		int size = ((BasicBean)lists.get(lists.size()-1)).getInt(0);
		formLists = new ArrayList<BasicBean>(size);
		StringBuilder row = null;
		for (BasicBean basicBean : lists) {
			if(formLists.get(basicBean.getInt(0)) == null) {
				row = new StringBuilder(basicBean.getString(1));
			} else {
				row = row.append(basicBean.getString(1));
			}
		}
		return null;
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
