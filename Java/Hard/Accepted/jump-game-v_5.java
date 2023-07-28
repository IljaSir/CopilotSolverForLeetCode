class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i, arr, d, dp));
        }
        return res;
    }
    private int dfs(int i, int[] arr, int d, int[] dp) {
        if (dp[i] > 0) {
            return dp[i];
        }
        int res = 1;
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[j] < arr[i]; j++) {
            res = Math.max(res, dfs(j, arr, d, dp) + 1);
        }
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; j--) {
            res = Math.max(res, dfs(j, arr, d, dp) + 1);
        }
        dp[i] = res;
        return res;
    }
}