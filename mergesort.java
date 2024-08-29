import java.util.Scanner;

public class Mergesort {

    // Method to merge two sorted halves of the array
    public static void merge(int[] array, int start, int middle, int end) {
        int[] mergedArray = new int[end - start + 1];
        int leftIndex = start;
        int rightIndex = middle + 1;
        int mergeIndex = 0;

        // Merge the two halves into mergedArray
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

        // Copy remaining elements from the left half, if any
        while (leftIndex <= middle) {
            mergedArray[mergeIndex] = array[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        // Copy remaining elements from the right half, if any
        while (rightIndex <= end) {
            mergedArray[mergeIndex] = array[rightIndex];
            rightIndex++;
            mergeIndex++;
        }

        // Copy mergedArray back into the original array
        for (int i = 0; i < mergedArray.length; i++) {
            array[start + i] = mergedArray[i];
        }
    }

    // Method to divide the array and sort each part
    public static void divide(int[] array, int start, int end) {
        if (start >= end) {
            return; // Base case: array with a single element is already sorted
        }

        int middle = start + (end - start) / 2;

        // Recursively sort the left and right halves
        divide(array, start, middle);
        divide(array, middle + 1, end);

        // Merge the sorted halves
        merge(array, start, middle, end);
    }

    // Main method to drive the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Input elements into the array
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the value at index " + i + ":");
            array[i] = scanner.nextInt();
        }

        System.out.print("Elements of the array are: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Perform merge sort
        divide(array, 0, size - 1);

        System.out.print("The sorted array is: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        scanner.close();
    }
}
