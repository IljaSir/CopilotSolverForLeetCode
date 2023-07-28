class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = Arrays.binarySearch(arr, arr[j] - arr[i]);
                if (k >= 0 && k < i) {
                    dp[i][j] = dp[k][i] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}