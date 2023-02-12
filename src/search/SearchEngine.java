package search;

import search.strategies.SearchStrategy;

import java.util.*;

public class SearchEngine {
    private Map<String, Set<Integer>> invertedIndex;
    private Database database;
    private SearchStrategy searchStrategy;

    public SearchEngine(String file) {
        this.database = Database.getInstance();
        database.fillList(file);
        this.invertedIndex = initInvertedIndex();
    }

    public List<String> search(String query) {
        return searchStrategy.find(query, invertedIndex, database.getData());
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<String> getAllData() {
        return database.getData();
    }

    private Map<String, Set<Integer>> initInvertedIndex() {
        var data = database.getData();
        var map = new HashMap<String, Set<Integer>>();

        for (int i = 0; i < data.size(); ++i) {
            addWordsIntoInvertedIndex(map, data.get(i), i);
        }

        return map;
    }

    private void addWordsIntoInvertedIndex(Map<String, Set<Integer>> map, String line, int index) {
        String[] words = line.toLowerCase().split(" ");

        for (var word : words) {
            var set = map.getOrDefault(word, new HashSet<>());
            set.add(index);
            map.put(word, set);
        }
    }
}
