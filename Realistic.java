import java.util.Arrays; // for printing array
/*
 * The expression arr.length is used as an index when assigning a new element
 * to the end of the array in the add() method. Due to array inducing in Java
 * start at 0, the last valid index is arr.length - 1. So when you resize the
 * array to add a new value, the new element should be placed at index arr.length,
 * which is one position past the last original element — i.e., the new last index
 * of the enlarged array. This works because the temporary array is already
 * declared as one element larger than the original array
 *
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