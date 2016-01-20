package com.cunchen.bean;

import java.util.List;

public class BeanListsUtil {
	
	public static int binarySerch (List<HabitsBean> lists, BasicBean bean) {
		int start = 0;
		int end = lists.size()-1;
		int pointer = (start + end + 1) / 2;
		HabitsBean row = lists.get(pointer);
		while(start <= end) {
			if(row.getId() == bean.getId()) {
				row.add(bean.getString(1));
				lists.set(pointer, row);
				return -1;
			} else if(start == end) {
				break;
			}else if(row.getId() > bean.getId()) {
			
				end = pointer;
			} else if(row.getId() < bean.getId()) {
				start = pointer;
			}
			pointer = (start + end + 1) / 2;
			row = lists.get(pointer);
		}
		if(row.getId() < bean.getId()) {
			pointer++;
		}
		return 0;
	}
}
