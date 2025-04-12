/**
 * Usiel Figueroa
 * April 12, 2025
 * CSD420-A311 Advanced Java Programming
 * M6: Programming Assignment 
 * Purpose: To demonstrate bubble sort using generics with both Comparable and Comparator interfaces.
 */

/** 
Reference 

[Design and Development - Video Production]. (2021, February 4). Insertion [Video]. Bellevue University. https://bellevue.mediaspace.kaltura.com/media/Insertion/1_jplnzivk 

(n.d.). Java Tutorial. W3schools. Retrieved April 12, 2025, from https://www.w3schools.com/java/ 

(n.d.). Bubble Sort in Java. Tpointtech. Retrieved April 12, 2025, from https://www.tpointtech.com/bubble-sort-in-java 
*/ 


import java.util.Comparator;

public class BubbleSort {

    // Bubble sort using Comparable interface
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: exit if already sorted
        }
    }

    // Bubble sort using Comparator interface
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped;
        for (int i = 0; i < list.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

/**
 * This class contains generic bubble sort methods using Comparable and Comparator.
 * It is not intended to be run directly.
 * 
 * To test the methods, run the TestBubbleSort class instead.
 */
