package search.strategies;

import java.util.*;

public class AllSearchStrategy  implements SearchStrategy {
    @Override
    public List<String> find(String query,
                             Map<String, Set<Integer>> invertedIndex,
                             List<String> allData) {
        var result = new ArrayList<String>();
        var indexSet = new HashSet<Integer>();
        query = query.toLowerCase();

        for (var key : invertedIndex.keySet()) {
            if (query.contains(key.toLowerCase())) {
                indexSet.addAll(invertedIndex.get(key));
            }
        }

        for (var index : indexSet) {
            result.add(allData.get(index));
            for (var str : query.split(" ")) {
                if (!allData.get(index).toLowerCase().contains(str)) {
                    result.remove(result.size() - 1);
                    break;
                }
            }
        }


        return result;
    }
}
