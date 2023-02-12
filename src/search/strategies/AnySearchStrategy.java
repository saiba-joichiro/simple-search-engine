package search.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnySearchStrategy implements SearchStrategy {
    @Override
    public List<String> find(String query, Map<String, Set<Integer>> invertedIndex, List<String> allData) {
        var result = new ArrayList<String>();
        query = query.toLowerCase();

        // Erick Dwight webb@gmail.com
        for (var str : query.split(" ")) {
            for (var key : invertedIndex.keySet()) {
                if (str.equalsIgnoreCase(key)) {
                    for (var value : invertedIndex.get(key)) {
                        result.add(allData.get(value));
                    }

                }
            }
        }

        return result;
    }
}
