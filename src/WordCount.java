import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


public class WordCount {

	public static class Map implements Mapper {

		@Override
		public void map(String key, String value, java.util.Map<String, Integer> collector) {
			String line = value.toString();
			StringTokenizer tokenizer = new StringTokenizer(line);
			while (tokenizer.hasMoreTokens()) {
				String word = tokenizer.nextToken();
				collector.put(word, 1);
			}
		}

	}

	public static class Reduce implements Reducer {

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
	}
}
