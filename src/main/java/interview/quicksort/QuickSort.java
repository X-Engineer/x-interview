package interview.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * @project: x-interview
 * @ClassName: QuickSort
 * @author: nzcer
 * @creat: 2023/4/10 12:10
 * @description: 快速排序算法
 */
public class QuickSort {
    static int round = 0;
    public static void main(String[] args) {
        int[] arr = {10, 9, 7, 5, 3, 2, 1, 8, 6, 4};
        System.out.println("原始：" + Arrays.toString(arr));
        //quickSort1(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);
        System.out.println("最终：" + Arrays.toString(arr));
    }

    /**
     * 快速排序方法一
     * 每次选中待排序数组的第一个元素作为 pivot
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort1(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int pivot = arr[i];
            while (i < j) {
                while (i < j && arr[j] > pivot) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] < pivot) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = pivot;
            System.out.println("轮次 " + round++ +Arrays.toString(arr));
            quickSort1(arr, left, i - 1);
            quickSort1(arr, i + 1, right);
        }
    }

    /**
     * 快速排序方法二
     * 每次随机从数组中拿到一个元素作为本轮将要正确归位的数值，然后将这个元素与数组末尾元素交换位置
     * 再设置两个指针 i 和 j，i 总是指向最后一个不大于末尾元素的值
     * j 在数组中不断右移，每当遇见一个小于等于 arr[right] 的值时，首先 i++，然后再交换 i，j 位置的值。
     * 最后当 j 遍历完数组之后，此时的 i 就是这一轮正确归位的元素的下标，直接返回 i 即可
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort2(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            System.out.println("轮次 " + round++ +Arrays.toString(arr));
            quickSort2(arr, left, pivot - 1);
            quickSort2(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        // 从 [left, right] 随机挑一个下标
        int randIdx = new Random().nextInt(right - left + 1) + left;
        // 随机挑选一个元素，将其交换到数组末尾，本轮需要归位的值为选中的这个元素
        swap(arr, randIdx, right);
        // 两个指针，i,j （i 总指向最后一个小于等于 arr[right] 的值，初始为 left - 1）
        int i = left - 1;
        for (int j = left; j <= right; j++) {
            if (arr[j] <= arr[right]) {
                i++;
                swap(arr, i, j);
            }
        }
        return i;
    }

    public static void swap(int[] arr, int left, int right) {
        if (left != right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }
}
