package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		
		m.put("one", 1); // auto boxing
		m.put("two", 2); // auto boxing
		m.put("three", 3); // auto boxing
		
		int i = m.get("one"); // auto unboxing
		int j = m.get(new String("one")); // 값으로 비교
		
		System.out.println(i);
		System.out.println(j);
		
		// 키 순회
		Set<String> s = m.keySet();
		for (String key : s) {
			System.out.println(m.get(key));
		}
		
		// 값 순회
		Collection<Integer> c = m.values();
		for (int num : c) {
			System.out.println(num);
		}
	}

}
