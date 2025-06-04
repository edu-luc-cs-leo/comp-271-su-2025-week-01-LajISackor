import java.util.Arrays; // for printing array
/*
 * The expression arr.length is used as an index when assigning a new element
 * to the end of the array in the add() method. Due to array inducing in Java
 * start at 0, the last valid index is arr.length - 1. So when you resize the
 * array to add a new value, the new element should be placed at index arr.length,
 * which is one position past the last original element — i.e., the new last index
 * of the enlarged array. This works because the temporary array is already
 * declared as one element larger than the original array.
 */

/**
 * A class to demonstrate minimum heap operations using arrays
 */
public class Realistic {

    /** Set up our test array. */
    static int[] arr = { 10, -5, 11, 2 };

     /**
     * This method finds and removes the smallest element in the array arr[].
     * Returns the smallest element as an Integer.
     * Then returns null if the array is empty.
     *
     * This method uses a temporary array to hold the new contents of arr[],
     * excluding the smallest element. The smallest element is identified
     * by scanning the array once, and the new array is created by copying
     * everything except that one element.
     *
     * @return Integer object holding the smallest value, or null if array is empty.
     */
    public static Integer getSmallest() {
        // Guard clause: return null if arr is empty or null
        Integer result = null;
        if (arr != null && arr.length > 0) {

            // Assume the first element is the smallest
            int smallestIndex = 0;

            // Loop to find the index of the smallest element
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[smallestIndex]) {
                    smallestIndex = i;
                }
            }

            // Save the smallest value before modifying the array
            result = arr[smallestIndex];

            // Create a new array with one less element
            int[] temporary = new int[arr.length - 1];

            // Copy all elements before the smallest index
            for (int i = 0; i < smallestIndex; i++) {
                temporary[i] = arr[i];
            }

            // Copy all elements after the smallest index
            for (int i = smallestIndex + 1; i < arr.length; i++) {
                temporary[i - 1] = arr[i];
            }

            // Replace arr with the updated array
            arr = temporary;
        }

        return result;
    }



    /**
     * Scan the entire array to find and remove its smallest value.
     * The method uses array arr[] created above.
     * 
     * @return int with the smallest value in array arr
     */
    public static int getSmallest() {
        // Assume smallest is first element
        int smallest_index = 0;
        // Scan the remaining elements, replacing the position of the smallest element
        // with the position of any element found to be smaller.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest_index]) {
                // found new smallest, update index
                smallest_index = i;
            }
        }
        // When loop is done, smallest_index points to smallest element. Save it in a
        // variable so that we can return its value when we are done.
        int result = arr[smallest_index];
        // Prepare to shrink the processed array by one element, effectively removing
        // its smallest element. A temporary array will hold the remaining elements.
        int[] temporary = new int[arr.length - 1];

        /*
         * Use two loops to copy the elements of arr[] to temporary[], except for the
         * smallest element. The first loop copies all the elements before the smallest
         * element and the second loop the elements after it.
         * 
         * EXPLANATION OF THE LOOPS (per last week's assignment): the first loop copies
         * all the elements before the smallest element to the temporary array. To
         * insure it does not "touch" the smallest element, the index of the loop in in
         * the range
         * 0 ≤ i < smallest_index.
         * 
         * The second loop copies all the elements after the smallest element to the
         * temporary array. To ensure this loop doesn't touch the smallest element
         * either, its range is
         * smallest_index < i < arr.length
         * 
         * In the first loop temporary and principal array (arr) indices are
         * synchronized. In the second array, the temporary array index becomes i-1
         * while the principal array index remains i. The shift from temporary[i] in the
         * first loop to temporary[i-1] in the second loop is to avoid a gap due to
         * skipping the smallest element. Also the i-1 index in the second loop ensures
         * that the temporary array index will not get out of bounds.
         */
        for (int i = 0; i < smallest_index; i++) {
            temporary[i] = arr[i];
        }
        for (int i = smallest_index + 1; i < arr.length; i++) {
            temporary[i - 1] = arr[i];
        }
        // replace principal array with temporary array.
        arr = temporary;
        return result; // smallest element
    } // method getSmallest

    /**
     * Adds a new element to the end of the principal array arr after it resizes up
     * to accomodate the new element.
     * 
     * @param value int to add to the array
     */
    public static void add(int value) {
        // Create a larger temporary array
        int[] temporary = new int[arr.length + 1];
        // Copy the principal array to the temporary one
        for (int i = 0; i < arr.length; i++) {
            temporary[i] = arr[i];
        }
        // Place the new value to the end of the temporary array.
        temporary[arr.length] = value;
        // Replace principal array with temporary array and we are done
        arr = temporary;
    } // method add

    /** Driver/simple test code */
    public static void main(String[] args) {
        System.out.printf("\n\nArray before removal of smallest element: %s",
                Arrays.toString(arr));
        System.out.printf("\nSmallest element found: %d", getSmallest());
        System.out.printf("\nArray after removal of smallest element: %s\n\n",
                Arrays.toString(arr));
    } // method main
} // class Realistic