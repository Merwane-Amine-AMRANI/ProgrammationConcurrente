package exercice3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Exercice3 {

	public static void main(String[] args) {
		
		String str = "enticonstitutionnellement";
		ArrayList<String> c = new ArrayList<>();
		Collections.addAll(c , str.split(""));
		
		Function<String, Integer> nombreOccur = (param) -> {
			return str.length() - str.replaceAll(param, "").length();
		};
		
		Set<Entry<Integer, Set<String>>> collect = c.stream().collect(Collectors.groupingBy(nombreOccur, Collectors.toSet())).entrySet();
		collect.forEach(System.out::println);
	}

}
