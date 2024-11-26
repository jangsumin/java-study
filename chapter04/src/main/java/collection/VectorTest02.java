package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		List<String> list = new Vector<>();

		list.add("둘리");
		list.add("마이콜");
		list.add("또치");

		// 순회1
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}

		System.out.println("==============");

		// 삭제
		list.remove(2);

		// 이터레이터를 확인하기 위한 순회2
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		System.out.println("==============");
		
		// 순회3
		for (String el : list) {
			System.out.println(el);
		}
	}

}
