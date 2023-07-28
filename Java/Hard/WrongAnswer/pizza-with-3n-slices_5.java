class Solution {
    public int maxSizeSlices(int[] slices) {
        
        int n = slices.length;
        int m = n / 3;
        return Math.max(
            maxSum(slices, 0, n - 2, m),
            maxSum(slices, 1, n - 1, m)
        );
    }
    
    private int maxSum(int[] slices, int start, int end, int m) {
        int n = end - start + 1;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int[] temp = Arrays.copyOf(dp, dp.length);
            for (int j = 1; j <= m; j++) {
                temp[j] = Math.max(dp[j], dp[j - 1] + slices[start + i - 1]);
            }
            dp = temp;
        }
        return dp[m];
    }
}