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
        //Reads the provided file and copies it into an arraylist.
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
        // Takes a string array and a search term.
        // Returns all indexes in which the search term is present.
        ArrayList<Integer> outArray = new ArrayList<>();

        for(int i = 0, max = inArray.size(); i < max; i++) {
            if (inArray.get(i).contains(search)) {
                outArray.add(i);
            }
        }
        return outArray;
    }

    private static void fancyPrint(ArrayList<Integer> out) {
        // handles the singular extraneous case

        if (out.isEmpty()) {
            System.out.println("$ rm -rf\n");
            return;
            // but seriously though, kind of curious on how these assignments are even tested
        }

        System.out.println("Match found in lines: " + out);
    }
}
