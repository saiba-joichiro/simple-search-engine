package search.strategies;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SearchStrategy {
    List<String> find(String query, Map<String,
            Set<Integer>> invertedIndex, List<String> allData);
}
