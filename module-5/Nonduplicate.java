/** 
Usiel Figueroa  
April 05, 2025 
CSD420-A311 Advanced Java Programming 
M5: Programming Assignment 
Purpose: Read words from a text file and display only non-duplicate words in ascending and descending order.
*/ 


/** 
Reference 

(n.d.). Java Tutorial. W3schools. Retrieved April 05, 2025, from https://www.w3schools.com/java/ 

(n.d.). Java HashSet Class. Programiz. Retrieved April 5, 2025, from https://www.programiz.com/java-programming/hashset 

(2019, October 1). Overcoming Hard Times Poems. Familyfriendpoems. Retrieved April 5, 2025, from https://www.familyfriendpoems.com/collection/poems-about-overcoming-hardships/

(n.d.). Java HashMap. W3schools. Retrieved April 5, 2025, from https://www.w3schools.com/java/java_hashmap.asp
*/ 


import java.io.*;
import java.util.*;

public class Nonduplicate {

    public static void main(String[] args) {
        // Create a Map to store words and their frequency
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read words from the file and count occurrences
        try {
            File file = new File("collection_of_words.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by whitespace
                for (String word : words) {
                    word = word.toLowerCase(); // Convert to lowercase to ensure case-insensitivity
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Filter out words that appear more than once
        List<String> nonDuplicateWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                nonDuplicateWords.add(entry.getKey());
            }
        }

        // Sort the list in ascending order
        Collections.sort(nonDuplicateWords);
        System.out.println("Non-duplicate words in ascending order:");
        for (String word : nonDuplicateWords) {
            System.out.println(word);
        }

        // Sort the list in descending order
        Collections.reverse(nonDuplicateWords);
        System.out.println("\nNon-duplicate words in descending order:");
        for (String word : nonDuplicateWords) {
            System.out.println(word);
        }
    }
}