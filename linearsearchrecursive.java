import java.util.*;

public class LinearSearch {

  static int linearSearch(int[] arr, int index, int val) {
       
        if (index >= arr.length) {
            return -1;
        }

        
        if (arr[index] == val) {
            return index;
        }

        return linearSearch(arr, index + 1, val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the value to search for: ");
        int valueToFind = scanner.nextInt();

        int result = linearSearch(arr, 0, valueToFind);

        if (result != -1) {
            System.out.println("Index of " + valueToFind + ": " + result);
        } else {
            System.out.println(valueToFind + " not found in the array.");
        }
    }
}
