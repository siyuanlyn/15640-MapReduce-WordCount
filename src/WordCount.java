import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import MapReduce.Library.Collector;
import MapReduce.Library.Mapper;
import MapReduce.Library.Pair;
import MapReduce.Library.Reducer;

public class WordCount {

	public static class Map implements Mapper<String, Integer> {

		@Override
		public void map(String key, String value, Collector<String, Integer> collector) {
			String line = value.toString();
			StringTokenizer tokenizer = new StringTokenizer(line);
			while (tokenizer.hasMoreTokens()) {
				String word = tokenizer.nextToken();
				collector.put(word, 1);
			}
		}


	}

	public static class Reduce implements Reducer<String, Integer> {

		@Override
		public void reduce(String key, List<Integer> values, java.util.Map<String, Integer> collector) {
			int sum = 0;
			Iterator<Integer> iterator = values.iterator();
			while (iterator.hasNext()) {
				sum += iterator.next();
			}
			collector.put(key, sum);
		}
	}
	
	
	public static void main(String[] args){
		// TODO
		
		Collector<String, Integer> c = new Collector<String, Integer>();
		Map m = new Map();
		m.map("", "a b c d a", c);
		Iterator<Pair<String, Integer>> i = c.iterator();
		while(i.hasNext()){
			Pair<String, Integer> p = i.next();
			System.out.println(p.getKey() + " | " + p.getValue());
		}
	}
}
