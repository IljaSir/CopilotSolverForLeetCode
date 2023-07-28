class Solution {
    public long maxOutput(int n, int[][] edges, int[] price) {
        
        long[] dp = new long[n];
        long[] sum = new long[n];
        long[] min = new long[n];
        long[] max = new long[n];
        Arrays.fill(min, Long.MAX_VALUE);
        Arrays.fill(max, Long.MIN_VALUE);
        
        for (int i = 0; i < n; i++) {
            dp[i] = price[i];
            sum[i] = price[i];
            min[i] = price[i];
            max[i] = price[i];
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dp[u] > dp[v]) {
                sum[v] += sum[u];
                min[v] = Math.min(min[v], min[u]);
                max[v] = Math.max(max[v], max[u]);
                dp[v] = max[v] - min[v];
            } else {
                sum[u] += sum[v];
                min[u] = Math.min(min[u], min[v]);
                max[u] = Math.max(max[u], max[v]);
                dp[u] = max[u] - min[u];
            }
        }
        
        long res = 0;
        for (long x : dp) {
            res = Math.max(res, x);
        }
        return res;
    }
}