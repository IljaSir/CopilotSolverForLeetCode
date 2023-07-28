class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(arr, d, i, dp));
        }
        return res;
    }
    private int dfs(int[] arr, int d, int i, int[] dp) {
        if (dp[i] > 0) {
            return dp[i];
        }
        dp[i] = 1;
        for (int j = 1; j <= d; j++) {
            if (i - j < 0 || arr[i - j] >= arr[i]) {
                break;
            }
            dp[i] = Math.max(dp[i], dfs(arr, d, i - j, dp) + 1);
        }
        for (int j = 1; j <= d; j++) {
            if (i + j >= arr.length || arr[i + j] >= arr[i]) {
                break;
            }
            dp[i] = Math.max(dp[i], dfs(arr, d, i + j, dp) + 1);
        }
        return dp[i];
    }
}