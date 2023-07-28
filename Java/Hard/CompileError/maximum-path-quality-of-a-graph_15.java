class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        ArrayList<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
        int[] dp = new int[n];
        dp[0] = values[0];
        int ans = 0;
        for (int time = 1; time <= maxTime; time++) {
            int[] dp2 = new int[n];
            for (int i = 0; i < n; i++) {
                for (Edge e : adj[i]) {
                    int j = e.v, w = e.w;
                    if (time >= w) {
                        dp2[j] = Math.max(dp2[j], dp[i] + values[j]);
                        ans = Math.max(ans, dp2[j]);
                    }
                }
            }
            dp = dp2;
        }
        return ans;
    }
}
    }
}