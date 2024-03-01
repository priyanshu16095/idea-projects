package img;

public class BinarySearch {
    public static void main(String[] args) {
        int target = 5;
        int[] arr= {1, 6, 5, 17, 3, 45, 2};
        binarySearch(arr, target);
    }
    public static void binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target) {
                System.out.println("The element is at index: " + mid);
                return;
            }
            // If target is greater, ignore left half
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                end = mid - 1;
            }
        }
        System.out.println("Element not found!");
    }
}
