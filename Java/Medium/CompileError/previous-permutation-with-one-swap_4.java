class Solution {
    public int[] prevPermOpt1(int[] arr) {
        
        int len = arr.length;
        int i = len - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return arr;
        }
        int j = len - 1;
        while (j >= 0 && arr[j] >= arr[i]) {
            j--;
        }
        while (j >= 0 && arr[j] == arr[j - 1]) {
            j--;
        }
        swap(arr, i, j);
        return arr;
    }
}