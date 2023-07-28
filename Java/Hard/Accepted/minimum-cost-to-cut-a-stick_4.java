class Solution {
    public int minCost(int n, int[] cuts) {
        
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }
        Arrays.sort(arr);
        int[][] dp = new int[m + 2][m + 2];
        for (int i = m; i >= 0; i--) {
            for (int j = i + 1; j < m + 2; j++) {
                if (j - i == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[j] - arr[i]);
                    }
                }
            }
        }
        return dp[0][m + 1];
    }
}