class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        final int MOD = (int) 1e9 + 7;
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            if (d > dist[u]) {
                continue;
            }
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(1, n, graph, dist, dp, MOD);
    }
    
    private int dfs(int u, int n, List<int[]>[] graph, int[] dist, int[] dp, int MOD) {
        if (u == n) {
            return 1;
        }
        if (dp[u] != -1) {
            return dp[u];
        }
        int ans = 0;
        for (int[] neighbor : graph[u]) {
            int v = neighbor[0];
            int w = neighbor[1];
            if (dist[v] > dist[u]) {
                ans = (ans + dfs(v, n, graph, dist, dp, MOD)) % MOD;
            }
        }
        return dp[u] = ans;
    }
}