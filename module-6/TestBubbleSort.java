/**
 * Usiel Figueroa
 * April 12, 2025
 * CSD420-A311 Advanced Java Programming
 * M6: Programming Assignment 
 * Purpose: To test the bubbleSort methods with Integer arrays,
 * bird species using Comparable, and X-Men characters using Comparator.
 */

/** 
Reference 

[Design and Development - Video Production]. (2021, February 4). Insertion [Video]. Bellevue University. https://bellevue.mediaspace.kaltura.com/media/Insertion/1_jplnzivk 

(n.d.). Java Tutorial. W3schools. Retrieved April 12, 2025, from https://www.w3schools.com/java/ 

(n.d.). Bubble Sort in Java. Tpointtech. Retrieved April 12, 2025, from https://www.tpointtech.com/bubble-sort-in-java 
*/ 


import java.util.Arrays;
import java.util.Comparator;

public class TestBubbleSort {

    public static void main(String[] args) {
        // Test with Integer array using Comparable
        Integer[] numbers = {6, 66, 4, 464, 44};
        System.out.println("Original Integer Array: " + Arrays.toString(numbers));
        BubbleSort.bubbleSort(numbers);
        System.out.println("Sorted (Comparable):    " + Arrays.toString(numbers));

        // Test with bird species using Comparable
        String[] birds = {"Falcon", "Eagle", "Parrot", "Swan", "Penguin"};
        System.out.println("\nOriginal Bird Species:  " + Arrays.toString(birds));
        BubbleSort.bubbleSort(birds);
        System.out.println("Sorted (Comparable):    " + Arrays.toString(birds));

        // Test with X-Men character names using Comparator (reverse order)
        String[] xmen = {"Wolverine", "Storm", "Beast", "Cyclops", "Rogue"};
        System.out.println("\nOriginal X-Men Names:   " + Arrays.toString(xmen));
        BubbleSort.bubbleSort(xmen, Comparator.reverseOrder());
        System.out.println("Sorted (Comparator ↓):  " + Arrays.toString(xmen));
    }
}
