class Solution {
    public int[] prevPermOpt1(int[] arr) {
        
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int i = arr.length - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return arr;
        }
        int j = arr.length - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }
        while (j > 0 && arr[j - 1] == arr[j]) {
            j--;
        }
        swap(arr, i, j);
        return arr;
    }
}