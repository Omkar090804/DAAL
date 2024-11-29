import java.util.*;

class QuickSort 
{

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            // Print array after each partitioning step
            System.out.println("Array after partitioning with pivot at index " + pivotIndex + ":");
            printArray(arr);

            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Choose the middle element as the pivot
        int mid = (low + high) / 2;
        int pivot = arr[mid];

        // Move the pivot to the end of the array
        swap(arr, mid, high);

        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        // Move the pivot to its correct position
        swap(arr, i, high);

        // Print the current state of the array after placing the pivot
        System.out.println("Pivot: " + pivot + " placed at index " + i);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] arr = new int[n];

        // Read the elements of the array
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Print the original array
        System.out.println("Original array:");
        printArray(arr);

        // Perform Quick Sort
        quicksort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        // Close the scanner
        scanner.close();
    }
}
