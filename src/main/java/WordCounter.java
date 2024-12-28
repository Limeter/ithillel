package main.java;
public class WordCounter {

    public static int countWords(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        input = input.replaceAll("\\d", "");

        String[] words = input.split("[^a-zA-Z]+");
        
        int count = 0;
        for (String word : words) {
            if (word.length() >= 3) {
                count++;
            }
        }
        return count;
    }
}

