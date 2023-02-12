package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
    private static Scanner in = new Scanner(System.in);

    public static int getOption() {
        // add some validation later
        return Integer.parseInt(in.nextLine());
    }

    public static String readLine() {
        // validation too
        return in.nextLine();
    }

}
