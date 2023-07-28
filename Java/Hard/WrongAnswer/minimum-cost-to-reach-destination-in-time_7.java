class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        int[][] dp = new int[n][maxTime+1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = passingFees[0];
        for(int i = 0; i < maxTime; i++) {
            for(int[] e: edges) {
                int u = e[0];
                int v = e[1];
                int t = e[2];
                if(i + t <= maxTime) {
                    dp[v][i+t] = Math.min(dp[v][i+t], dp[u][i] + passingFees[v]);
                    dp[u][i+t] = Math.min(dp[u][i+t], dp[v][i] + passingFees[u]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= maxTime; i++) {
            min = Math.min(min, dp[n-1][i]);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}