package com.cunchen.analyzer;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cunchen.bean.HabitsBean;
import com.cunchen.input.ReaderFormat;

/**
 * Collaborative Filter
 * @author wqd
 *2016/01/18
 */
public class CollaborativeFilteringAnalyzer extends Analyzer {
	
	/**
	 * Calculate similarity value of users in lists and save value 
	 * into the recommendTable,value describes how popular the item is.
	 * @param lists
	 * @return recommendTable[][]
	 */
	public float[][] userSimilarityConsine(List<?> lists) {
		Set<String> setsA = new HashSet<String>(), setsB = new HashSet<String>();
		float[][] recommendTable = new float[lists.size()][lists.size()];
		HabitsBean a, b;
		for (int i = 0; i < lists.size(); i++) {
			a = (HabitsBean)lists.get(i);
			setsA.addAll(a.getArray());
			recommendTable[i][i] = 0;
			for (int j = i + 1; j < lists.size(); j++) {
				b = (HabitsBean)lists.get(j);
				float count = 0;
				
				//caculate the similarity value for a comparing with b
				for (int h = 0; h < b.getSize(); h++) {
					if(setsA.contains(b.getString(h)))
						count ++;
				}
				recommendTable[i][j] = (float) (count/(Math.sqrt(a.getSize() * b.getSize())));
				
				//caculate the similarity value for b comparing with a
				setsB.addAll(b.getArray());
				for (int h = 0; h < a.getSize(); h++) {
					if(setsB.contains(a.getString(h)))
						count ++;
				}
				recommendTable[j][i] = (float) (count/(Math.sqrt(a.getSize() * b.getSize())));
				
//				if(recommendTable[j][i] > 1)
//				System.out.println("recommendTable[" + j + "][" + i + "]" + recommendTable[j][i] + " : " 
//									+ "recommendTable[" + i + "][" + j + "]" + recommendTable[i][j]);
				setsB.clear();
			}
			setsA.clear();
		}
		return recommendTable;
	}
	
	public static void main(String[] args) {
		CollaborativeFilteringAnalyzer analyzer = new CollaborativeFilteringAnalyzer();
		try {
			analyzer.userSimilarityConsine(new ReaderFormat().formateLogUser("E:/WorkSpace/Input/ml-100k/u1.base"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
