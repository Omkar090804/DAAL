import java.util.*;

public class Mergesort {

    public static void merge(int[] array, int start, int middle, int end) {
        int[] mergedArray = new int[end - start + 1];
        int leftIndex = start;
        int rightIndex = middle + 1;
        int mergeIndex = 0;

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

        while (leftIndex <= middle) {
            mergedArray[mergeIndex] = array[leftIndex];
            leftIndex++;
            mergeIndex++;
        }

        while (rightIndex <= end) {
            mergedArray[mergeIndex] = array[rightIndex];
            rightIndex++;
            mergeIndex++;
        }

        for (int i = 0; i < mergedArray.length; i++) {
            array[start + i] = mergedArray[i];
        }
    }

    public static void divide(int[] array, int start, int end) {
        if (start >= end) {
            return; 
        }

        int middle = start + (end - start) / 2;

       
        divide(array, start, middle);
        divide(array, middle + 1, end);

        merge(array, start, middle, end);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter the value at index " + i + ":");
            array[i] = scanner.nextInt();
        }

        System.out.print("Elements of the array are: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        divide(array, 0, size - 1);

        System.out.print("The sorted array is: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();

        scanner.close();
    }
}
