package search.strategies;

import java.util.*;

public class NoneSearchStrategy implements SearchStrategy {
    @Override
    public List<String> find(String query,
                             Map<String, Set<Integer>> invertedIndex,
                             List<String> allData) {
        query = query.toLowerCase();
        var result = new ArrayList<String>();
        var indexSet = new HashSet<Integer>();

        for (var key : invertedIndex.keySet()) {
            if (!query.contains(key.toLowerCase())) {
                indexSet.addAll(invertedIndex.get(key));
            }
        }

        for (var index : indexSet) {
            result.add(allData.get(index));
            for (var str : allData.get(index).split(" ")) {
                if (query.contains(str.toLowerCase())) {
                    result.remove(result.size() - 1);
                    break;
                }
            }
        }

        return result;
    }
}
