class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }
        int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = values[0];
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int u = p[0], t = p[1];
            if (u == n - 1) {
                res = Math.max(res, dp[u][t]);
            }
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (t + w > maxTime) {
                    continue;
         
        int ans = 0;
        for (int t = 0; t <= maxTime; t++) {
            ans = Math.max(ans, dp[0][t]);
        }
        return ans;
    }
}