class Solution {
    public int[] prevPermOpt1(int[] arr) {
        
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return arr;
        }
        int j = n - 1;
        while (j > i && arr[j] >= arr[i]) {
            j--;
        }
        while (j > i && arr[j] == arr[j - 1]) {
            j--;
        }
        swap(arr, i, j);
        return arr;
    }
}