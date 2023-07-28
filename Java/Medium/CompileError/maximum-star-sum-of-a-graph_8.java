class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        int n = vals.length;
        int[] dp = new int[n];
        int[] sum = new int[n];
        int[] count = new int[n];
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            count[u]++;
            count[v]++;
        }
        for (int i = n - 1; i >= 0; i--) {
            int u = i;
            sum[u] = vals[u];
            dp[u] = vals[u];
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int[] e : edges) {
                int v = e[0] == u ? e[1] : e[0] == v ? e[1] : -1;
                if (v == -1) continue;
                pq.add(dp[v]);
                sum[u] += sum[v];
            }
            while (pq.size() > k) {
                sum[u] -= pq.poll();
            }
            dp[u] = Math.max(dp[u], sum[u]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}