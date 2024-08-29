import java.util.*;
public class BinarySearch {

    static int binarySearch(int arr[], int beg, int end, int val) {
        if (end >= beg) {
            int mid = (beg + end) / 2;

            if (arr[mid] == val) {
                return mid;
            }

            if (arr[mid] < val) {
                return binarySearch(arr, mid + 1, end, val);
            }

            return binarySearch(arr, beg, mid - 1, val);
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];

        System.out.println("Enter the number of elements in array:");
        int n = sc.nextInt();

        System.out.println("Enter the elements in sorted order:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("The Array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Which element is to be searched?");
        int val = sc.nextInt();

        int res = binarySearch(arr, 0, n - 1, val);

        if (res == -1) {
            System.out.println("Element not present");
        } else {
            System.out.println("Element present at index " + res);
        }
    }
}
