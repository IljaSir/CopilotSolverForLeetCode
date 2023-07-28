class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = binarySearch(arr, 0, i, arr[j] - arr[i]);
                if (k >= 0) {
                    dp[i][j] = dp[k][i] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
    
    private int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}