package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Database {
    private List<String> data;
    private static Database instance = null;

    private Database() {
        this.data = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public List<String> getData() {
        return Collections.unmodifiableList(data);
    }

    public void fillList(String file) {
        try (Scanner scan = new Scanner(new File(file))) {
            while (scan.hasNext()) {
                data.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File: " + file + ", was not found!");
            System.exit(0);
        }
    }
}
