import java.util.*;

/**
 * Usiel Figueroa
 * March 23, 2025
 * CSD420-A311 Advanced Java Programming  
 * Module 3 Programming Assignment
 *
 * This program generates an ArrayList with 50 random integers (1-20),
 * removes duplicates, and prints both the original and filtered lists.
 */


/** 

Reference 

(n.d.). Generics in Java. Geeksforgeeks. Retrieved March 23, 2025, from https://www.geeksforgeeks.org/generics-in-java/ 

(n.d.). Java Tutorial. W3schools. Retrieved March 23, 2025, from https://www.w3schools.com/java/ 

(n.d.). Java - Generics. Tutorialspoint. Retrieved March 23, 2025, from https://www.tutorialspoint.com/java/java_generics.htm 

(n.d.). Java LinkedHashSet. Geeksforgeeks. Retrieved March 23, 2025, from https://www.geeksforgeeks.org/linkedhashset-in-java-with-examples/ 

*/ 

public class RemoveDuplicates {

    /**
     * Removes duplicate elements from an ArrayList and returns a new ArrayList.
     * @param list The original ArrayList with possible duplicates.
     * @param <E> The type of elements in the list.
     * @return A new ArrayList containing only unique elements.
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        // Create an ArrayList and fill it with 50 random values between 1 and 20
        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        // Print the original list
        System.out.println("Original List: " + originalList);

        // Remove duplicates and print the new list
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);
        System.out.println("Unique List: " + uniqueList);
    }
}
