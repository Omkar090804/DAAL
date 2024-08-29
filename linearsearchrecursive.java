public class LinearSearch
{
    static int linearSearch(int arr[], int index, int val)
    {
        if (index >= arr.length) return -1;

        if (arr[index] == val) return index;

        return linearSearch(arr, index + 1, val);
    }

    public static void main(String[] args)
    {
        int[] arr = {2, 4, 6, 8, 10};
        int valueToFind = 8;
        int result = linearSearch(arr, 0, valueToFind);
        System.out.println(result); 
    }
}
