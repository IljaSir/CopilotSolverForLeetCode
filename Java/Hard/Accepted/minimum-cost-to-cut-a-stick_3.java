class Solution {
    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        int[] cuts2 = new int[cuts.length + 2];
        cuts2[0] = 0;
        cuts2[cuts.length + 1] = n;
        for (int i = 0; i < cuts.length; i++) {
            cuts2[i + 1] = cuts[i];
        }
        cuts = cuts2;
        int[][] dp = new int[cuts.length][cuts.length];
        for (int i = 0; i < cuts.length; i++) {
            for (int j = 0; j < cuts.length; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, cuts.length - 1, cuts, dp);
    }
    public int dfs(int start, int end, int[] cuts, int[][] dp) {
        if (end - start <= 1) {
            return 0;
        }
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            ans = Math.min(ans, dfs(start, i, cuts, dp) + dfs(i, end, cuts, dp) + cuts[end] - cuts[start]);
        }
        dp[start][end] = ans;
        return ans;
    }
}