

/**
 * Usiel Figueroa
 * March 26, 2025
 * CSD420-A311 Advanced Java Programming 
 * M4: Programming Assignment
 *
 * Purpose: This program compares the performance of traversing a LinkedList using an iterator versus the get(index) method for 50,000 and 500,000 integers.
 */

/** 
Reference 

(2024, December 10). ArrayList get(index) Method in Java with Examples. Geeksforgeeks. Retrieved March 26, 2025, from https://www.geeksforgeeks.org/arraylist-get-method-java-examples/ 

(n.d.). Java Iterator. W3schools. Retrieved March 26, 2025, from https://www.w3schools.com/java/java_iterator.asp 

(n.d.). Java Tutorial. W3schools. Retrieved March 26, 2025, from https://www.w3schools.com/java/ 

Spitsin, M. (n.d.). To Index or Iterate. Medium. Retrieved March 26, 2025, from https://programmerr47.medium.com/to-index-or-iterate-7b81039e5484

(n.d.). Java - Queue Interface. Tutorialspoint. Retrieved March 26, 2025, from https://www.tutorialspoint.com/java/java_util_queue.htm
*/ 

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraversalTest {
    public static void main(String[] args) {
        int[] sizes = {50000, 500000};

        for (int size : sizes) {
            System.out.println("Testing with " + size + " elements");
            LinkedList<Integer> list = new LinkedList<>();

            // Populate LinkedList with integers
            for (int i = 0; i < size; i++) {
                list.add(i);
            }

            // Measure time using iterator
            long startTime = System.nanoTime();
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            long iteratorTime = System.nanoTime() - startTime;
            System.out.println("Iterator traversal time: " + (iteratorTime / 1_000_000.0) + " ms");

            // Measure time using get(index)
            startTime = System.nanoTime();
            for (int i = 0; i < list.size(); i++) {
                list.get(i);
            }
            long getTime = System.nanoTime() - startTime;
            System.out.println("get(index) traversal time: " + (getTime / 1_000_000.0) + " ms");

            System.out.println("-------------------------------");
        }
    }
}

/** 
Notes:

The Iterator was faster every time I ran the test, especially as the list size increases.
Testing with 50000 elements
get(index) traversal time: 940.876922 ms
-------------------------------
Testing with 500000 elements
Iterator traversal time: 5.1749 ms
get(index) traversal time: 96697.840534 ms
-------------------------------

Testing with 50000 elements
get(index) traversal time: 939.576441 ms
-------------------------------
Testing with 500000 elements
Iterator traversal time: 3.83464 ms
get(index) traversal time: 96070.348321 ms
-------------------------------

The performance difference is due to get(index) requiring traversal from the start for each index lookup in a LinkedList.

*/ 



