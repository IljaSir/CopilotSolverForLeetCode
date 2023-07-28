class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            int[] rowSum = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][right];
                }
                max = Math.max(max, dpmax(rowSum, k));
            }
        }
        return max;
    }
    
    private int dpmax(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (dp[i] <= k) {
                max = Math.max(max, dp[i]);
            }
            for (int j = 0; j < i; j++) {
                dp[j] += nums[i];
                if (dp[j] <= k) {
                    max = Math.max(max, dp[j]);
                }
            }
        }
        return max;
    }
}