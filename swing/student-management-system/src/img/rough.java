package img;

public class rough {
    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
        int target = 10;

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target is greater, ignore left half
            else if (arr[mid] < target) {
                left = mid + 1;
            }

            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Element not present in the array
        return -1;
    }
}
