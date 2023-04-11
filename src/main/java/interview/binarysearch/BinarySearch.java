package interview.binarysearch;

/**
 * @project: x-interview
 * @ClassName: BinarySearch
 * @author: nzcer
 * @creat: 2023/4/10 16:12
 * @description:
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 9};
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 6));
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
