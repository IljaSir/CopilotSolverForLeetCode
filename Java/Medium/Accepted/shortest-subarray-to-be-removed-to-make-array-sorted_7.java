class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        
        int n = arr.length;
        int i = 0, j = n-1;
        while (i < n-1 && arr[i] <= arr[i+1]) i++;
        if (i == n-1) return 0;
        while (j > 0 && arr[j-1] <= arr[j]) j--;
        int ans = Math.min(n-i-1, j);
        int k = 0;
        while (k <= i && j < n) {
            if (arr[k] <= arr[j]) {
                ans = Math.min(ans, j-k-1);
                k++;
            } else {
                j++;
            }
        }
        return ans;
    }
}