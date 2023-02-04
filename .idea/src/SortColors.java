/*
75. Sort Colors
https://leetcode.com/problems/sort-colors/description/
 */

class SortColors {
    public static void merge(int[] arr, int[] temp, int low, int high) {
        int mid = (low + high) / 2;
        int i = low;
        int j = mid + 1;
        int k = 0; // lenth of temp
        int total = high - low + 1;

        while (k < total) {
            if (i > mid) {
                temp[k] = arr[j];
                j ++;
            } else if (j > high) {
                temp[k] = arr[i];
                i ++;
            }
            else if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i ++;
            } else {
                temp[k] = arr[j];
                j ++;
            }
            k ++;
        }

        for (int a = 0; a < total; a ++) {
            arr[low + a] = temp[a];
        }
    }
    public void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low >= high)
            return;

        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);
        merge(arr, temp, low, high);
    }
    public void sortColors(int[] nums) {
        int[] result = new int[nums.length];
        mergeSort(nums, result, 0, nums.length -1);
    }
}