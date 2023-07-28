class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        int mod = 1000000007;
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            int d = top[1];
            if (d > dis[u]) {
                continue;
            }
            for (int[] next : graph[u]) {
                int v = next[0];
                int w = next[1];
                if (dis[v] > dis[u] + w) {
                    dis[v] = dis[u] + w;
                    pq.add(new int[]{v, dis[v]});
                }
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(graph, dis, dp, 1, n, mod);
    }

    private int dfs(List<int[]>[] graph, int[] dis, int[] dp, int u, int n, int mod) {
        if (u == n) {
            return 1;
        }
        if (dp[u] != -1) {
            return dp[u];
        }
        int res = 0;
        for (int[] next : graph[u]) {
            int v = next[0];
            if (dis[v] > dis[u]) {
                res = (res + dfs(graph, dis, dp, v, n, mod)) % mod;
            }
        }
        dp[u] = res;
        return res;
    }
}