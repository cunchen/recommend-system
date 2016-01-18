package com.cunchen.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cunchen.bean.BasicBean;
import com.cunchen.input.ReaderFormat;

/**
 * Collaborative Filter
 * @author wqd
 *2016/01/18
 */
public class CollaborativeFilteringAnalyzer extends Analyzer {
	
	public float userSimilarityConsine(List<?> lists) {
		BasicBean basicBeanA = null;
		BasicBean basicBeanB = null;
		System.out.println(((BasicBean)lists.get(lists.size()-1)).getInt(1));
		List parameters = new ArrayList();
		for (int i = 0; i < lists.size(); i++) {
			for (int j = i + 1; j < lists.size(); j++) {
				basicBeanA = (BasicBean) lists.get(i);
				basicBeanB = (BasicBean) lists.get(j);
				
			}
		}
//		System.out.println(basicBean.getInt(0) + "\t" + basicBean.getInt(1) + "\t" + basicBean.getInt(2));
		return 0;
	}
	
	public static void main(String[] args) {
		CollaborativeFilteringAnalyzer analyzer = new CollaborativeFilteringAnalyzer();
		try {
			analyzer.userSimilarityConsine(new ReaderFormat().read("E:/WorkSpace/Input/ml-100k/u1.base"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
