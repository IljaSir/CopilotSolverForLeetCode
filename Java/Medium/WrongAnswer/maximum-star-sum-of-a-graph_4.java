class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        int n = vals.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = vals[0];
        for (int i = 0; i < k; i++) {
            int[] ndp = new int[n];
            Arrays.fill(ndp, Integer.MIN_VALUE);
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                ndp[u] = Math.max(ndp[u], dp[v]);
                ndp[v] = Math.max(ndp[v], dp[u]);
            }
            for (int j = 0; j < n; j++) {
                ndp[j] = Math.max(ndp[j], dp[j] + vals[j]);
            }
            dp = ndp;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}