class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        
        int n = arr.length;
        int i = 0;
        while (i < n - 1 && arr[i] <= arr[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return 0;
        }
        int j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        int result = Math.min(n - i - 1, j);
        int k = 0;
        int l = j;
        while (k <= i && l < n) {
            if (arr[k] <= arr[l]) {
                result = Math.min(result, l - k - 1);
                k++;
            } else {
                l++;
            }
        }
        return result;
    }
}