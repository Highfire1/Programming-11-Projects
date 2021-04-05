/*
Text Scanner 1600
By [redacted]

Looks for "ProgrammingHistory.txt" by default
(neat zero errors & zero warnings)
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "ProgrammingHistory.txt";
        String search = "the";

        ArrayList<String> text = createLineArray(filePath);
        ArrayList<Integer> out = searchForWord(text, search);
        fancyPrint(out);
    }

    private static ArrayList<String> createLineArray(String filename) throws IOException {
        //reads and converts the provided file into an arraylist
        ArrayList<String> lines = new ArrayList<>();
        FileReader test = new FileReader(filename);
        BufferedReader buffer = new BufferedReader(test);

        String line;
        while((line = buffer.readLine()) != null) {
            lines.add(line);
        }

        buffer.close();
        return lines;
    }

    private static ArrayList<Integer> searchForWord(ArrayList<String> inArray, String search) {
        // takes a string array then searches it for the search term
        // returns all indexes in which the search term is present
        ArrayList<Integer> outArray = new ArrayList<>();

        if (inArray.isEmpty()) { return outArray; } // never runs but its the thought that counts right

        int i = 0;
        int max = inArray.size();
        String line;

        while(i < max) {
            line = inArray.get(i);
            if (line.contains(search)) {
                outArray.add(i);
            }
            i += 1;
        }
        return outArray;
    }

    private static void fancyPrint(ArrayList<Integer> out) {
        // prints fancily
        if (out.isEmpty()) {
            System.out.println("$ rm -rf\n");
            return;
            //but seriously though, kind of curious on how you do test these
        }

        System.out.println("Match found in lines:");
        for(int i : out) {
            System.out.println(i + 1); // its for a human, if intellij starts at 1 this should start at 1
        }
    }
}
