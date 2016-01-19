package com.cunchen.analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cunchen.bean.BasicBean;
import com.cunchen.input.ReaderFormat;

/**
 * Collaborative Filter
 * @author wqd
 *2016/01/18
 */
public class CollaborativeFilteringAnalyzer extends Analyzer {
	
	public float userSimilarityConsine(List<?> lists) {
		Set<String> setsCommon = new HashSet<String>();
//		System.out.println(((BasicBean)lists.get(lists.size()-1)).getInt(1));
		List parameters = new ArrayList();
		for (int i = 0; i < lists.size(); i++) {
			for (int j = i + 1; j < lists.size(); j++) {
				
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
