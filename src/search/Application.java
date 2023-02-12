package search;
import search.strategies.AllSearchStrategy;
import search.strategies.AnySearchStrategy;
import search.strategies.NoneSearchStrategy;

import java.util.*;

public class Application {
    private SearchEngine searchEngine;
    private boolean isQuit = false;

    public Application(String[] args) {
        if (args.length != 2 || !args[0].equals("--data")) {
            System.exit(-1);
        }

        this.searchEngine = new SearchEngine(args[1]);
    }

    public void start() {
        while (!isQuit) {
            System.out.println("""
                    === Menu ===
                    1. Find a person
                    2. Print all people
                    0. Exit""");

            int option = ConsoleInput.getOption();
            System.out.println();

            processOption(option);

        }

    }
    private void processOption(int option) {
        switch (option) {
            case 0:
                isQuit = true;
                System.out.println("Bye!");
                break;
            case 1:
                System.out.println("Select a matching strategy: ALL, ANY, NONE");
                processStrategy(ConsoleInput.readLine().toLowerCase());
                System.out.println("Enter a name or email to search all suitable people.");
                String query = ConsoleInput.readLine().toLowerCase();
                printAllItems(searchByQuery(query));
                break;
            case 2:
                printAllItems(searchEngine.getAllData());
                break;
            default:
                System.out.println("Incorrect option! Try again.\n");
        }
    }

    private void processStrategy(String strategy) {
        switch (strategy) {
            case "all" -> searchEngine.setSearchStrategy(new AllSearchStrategy());
            case "any" -> searchEngine.setSearchStrategy(new AnySearchStrategy());
            case "none" -> searchEngine.setSearchStrategy(new NoneSearchStrategy());
        }
    }

    private List<String> searchByQuery(String query) {
        return searchEngine.search(query);
    }

    private void printAllItems(List<String> list) {
        for (var item : list) {
            System.out.println(item);
        }
        System.out.println();

    }


}
