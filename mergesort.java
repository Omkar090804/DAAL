import java.util.*;
public class Mergesort {
    public static void merge(int[] array, int start, int middle, int end) {
        int[] mergedArray = new int[end - start + 1];
        int leftIndex = start;
        int rightIndex = middle + 1;
        int mergeIndex = 0;

        // Merge the two subarrays into mergedArray
        while (leftIndex <= middle && rightIndex <= end) {
            if (array[leftIndex] <= array[rightIndex]) {
                mergedArray[mergeIndex] = array[leftIndex];
                leftIndex++;
            } else {
                mergedArray[mergeIndex] = array[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        // Copy the remaining elements from the left subarray
        while (leftIndex <= middle) {
            mergedArray[mergeIndex] = array[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        // Copy the remaining elements from the right subarray
        while (rightIndex <= end) {
            mergedArray[mergeIndex] = array[rightIndex];
            rightIndex++;
            mergeIndex++;
        }

        // Copy the merged elements back into the original array
        for (int i = 0; i < mergedArray.length; i++) {
            array[start + i] = mergedArray[i];
        }

        // Print the state of the array after merging
        System.out.print("Array after merging: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Method to divide the array into subarrays
    public static void divide(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;

        // Recursive calls to divide the array
        divide(array, start, middle);
        divide(array, middle + 1, end);

        // Merge the divided subarrays
        merge(array, start, middle, end);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Read the elements of the array
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the value at index " + i + ":");
            array[i] = scanner.nextInt();
        }

        // Print the original array
        System.out.print("Original array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Perform Merge Sort
        divide(array, 0, size - 1);

        // Print the sorted array
        System.out.print("The sorted array is: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Close the scanner
        scanner.close();
    }
}
