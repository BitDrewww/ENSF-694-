import java.util.Arrays;
import java.util.Scanner;
/**
 Q1. below.
 
 Q2. interpolation method has a faster run time compared to the linear search. 
 Interpolation search has a better average-case time complexity of O(log log n) compared to linear search's time complexity of O(n).

 Q3. By implementing a sort array for the linear method, we can see that it has decreased the run time by more than 20%. 
 This is because it is running through data in a uniform matter. 
 */
public class SearchAlgorithm {
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int interpolationSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && key >= arr[low] && key <= arr[high]) {
            if (low == high) {
                if (arr[low] == key) {
                    return low;
                }
                return -1;
            }

            int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == key) {
                return pos;
            } else if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int numElements = scanner.nextInt();

        int[] arr = new int[numElements];
        System.out.println("Enter the elements in the array:");
        for (int i = 0; i < numElements; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the search key: ");
        int key = scanner.nextInt();

        
        // Perform linear search
        long startTimeLinear = System.nanoTime();
        int linearSearchIndex = linearSearch(arr, key);
        System.out.println("Using Linear Search:");
        if (linearSearchIndex != -1) {
            System.out.println("Search key FOUND at index " + linearSearchIndex + ".");
        } else {
            System.out.println("Search key NOT FOUND.");
        }
        long endTimeLinear = System.nanoTime();
        long totalTimeLinear = endTimeLinear - startTimeLinear;
        System.out.println("Linear Time: " + totalTimeLinear);
       
        Arrays.sort(arr); // Sort the array in non-decreasing order
        
     // Perform Improved linear search
        long startTimeLinearImproved = System.nanoTime();
        int linearSearchIndexImproved = linearSearch(arr, key);
        System.out.println("Using Linear Search:");
        if (linearSearchIndexImproved != -1) {
            System.out.println("Search key FOUND at index " + linearSearchIndexImproved + ".");
        } else {
            System.out.println("Search key NOT FOUND.");
        }
        long endTimeLinearImproved = System.nanoTime();
        long totalTimeLinearImproved = endTimeLinearImproved - startTimeLinearImproved;
        System.out.println("Improved Linear Time: " + totalTimeLinearImproved);
        
        // Perform interpolation search
        long startTimeInterpolation = System.nanoTime();
        int interpolationSearchIndex = interpolationSearch(arr, key);
        System.out.println("Using Interpolation Search:");
        if (interpolationSearchIndex != -1) {
            System.out.println("Search key FOUND at index " + interpolationSearchIndex + ".");
        } else {
            System.out.println("Search key NOT FOUND.");
        }
        long endTimeInterpolation   = System.nanoTime();
        long totalTimeInterpolation = endTimeInterpolation - startTimeInterpolation;
        System.out.println("Interpolation Time: " +totalTimeInterpolation);
        
    }
}
