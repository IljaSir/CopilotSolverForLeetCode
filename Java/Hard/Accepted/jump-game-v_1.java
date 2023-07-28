class Solution {
    public int maxJumps(int[] arr, int d) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(arr, d, dp, i));
        }
        return res;
    }
    
    private int dfs(int[] arr, int d, int[] dp, int i) {
        if (dp[i] != 0) return dp[i];
        int res = 1;
        for (int j = i - 1; j >= Math.max(0, i - d); j--) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, dfs(arr, d, dp, j) + 1);
        }
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d); j++) {
            if (arr[j] >= arr[i]) break;
            res = Math.max(res, dfs(arr, d, dp, j) + 1);
        }
        dp[i] = res;
        return res;
    }
}