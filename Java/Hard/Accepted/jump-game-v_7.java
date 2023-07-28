class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(arr, i, d, dp));
        }
        return ans;
    }
    private int dfs(int[] arr, int i, int d, int[] dp) {
        if (dp[i] != 1) {
            return dp[i];
        }
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i]) {
                break;
            }
            dp[i] = Math.max(dp[i], dfs(arr, j, d, dp) + 1);
        }
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {
            if (arr[j] >= arr[i]) {
                break;
            }
            dp[i] = Math.max(dp[i], dfs(arr, j, d, dp) + 1);
        }
        return dp[i];
    }
}