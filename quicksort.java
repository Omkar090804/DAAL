import java.util.Scanner;

public class Quicksort 
{
    public static int partition(int arr[], int beg, int end) 
  {
        int pivot = arr[end];
        int i = beg - 1;
        for (int j = beg; j < end; j++) {
          
            if (arr[j] < pivot) 
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        return i;
    }

    public static void quickSort(int arr[], int beg, int end) 
  {
        if (beg < end) 
        {
            int pivot = partition(arr, beg, end);
            quickSort(arr, beg, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public static void main(String args[]) 
  {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the size of the array");
    
        int n = sc.nextInt();
        int arr[] = new int[n];
    
        for (int i = 0; i < n; i++) 
        {
            System.out.println("Enter the value at index " + i);
            arr[i] = sc.nextInt();
        }
    
        System.out.print("Elements of the array are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    
        System.out.println();
    
        quickSort(arr, 0, n - 1);
    
        System.out.print("The sorted array is: ");
    
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    
        System.out.println();
    }
}

