class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        int[] ans = new int[n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = sumOfDistancesInTree(i, edges, dp);
        }
        return ans;
    }

    public int sumOfDistancesInTree(int i, int[][] edges, int[][] dp) {
        if (dp[i][i] != -1) {
            return dp[i][i];
        }
        int ans = 0;
        for (int j = 0; j < edges.length; j++) {
            if (edges[j][0] == i) {
                ans += sumOfDistancesInTree(edges[j][1], edges, dp) + 1;
            } else if (edges[j][1] == i) {
                ans += sumOfDistancesInTree(edges[j][0], edges, dp) + 1;
            }
        }
        dp[i][i] = ans;
        return ans;
    }
}