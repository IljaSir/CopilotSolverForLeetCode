class Solution {
    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            arr[i + 1] = cuts[i];
        }
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return dfs(arr, 0, arr.length - 1, dp);
    }

    private int dfs(int[] arr, int i, int j, int[][] dp) {
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        if (j - i == 1) return 0;
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, dfs(arr, i, k, dp) + dfs(arr, k, j, dp) + arr[j] - arr[i]);
        }
        dp[i][j] = res;
        return res;
    }
}