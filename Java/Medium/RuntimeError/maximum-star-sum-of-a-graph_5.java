class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        int n = vals.length;
        int[] dp = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = vals[i];
            sum[i] = vals[i];
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dp[u] < dp[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            dp[u] = Math.max(dp[u], dp[v] + vals[u]);
            sum[u] += sum[v];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(dp[i] - sum[i]);
        }
        int ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = Math.max(ans, sum[pq.poll()] + i * (i - 1) / 2);
        }
        return ans;
    }
}