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
        int j = i + 1;
        while (j < n && arr[j] < arr[i]) {
            j++;
        }
        int k = j - 1;
        while (k > i && arr[k] == arr[j]) {
            k--;
        }
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
        return arr;
    }
}