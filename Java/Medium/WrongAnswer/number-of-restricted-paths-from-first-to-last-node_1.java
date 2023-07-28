class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            for (int[] v : graph.getOrDefault(u, new ArrayList<>())) {
                if (dist[v[0]] > dist[u] + v[1]) {
                    dist[v[0]] = dist[u] + v[1];
                    pq.offer(new int[]{v[0], dist[v[0]]});
                }
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(1, n, graph, dist, dp);
    }

    private int dfs(int u, int n, Map<Integer, List<int[]>> graph, int[] dist, int[] dp) {
        if (u == n) {
            return 1;
        }
        if (dp[u] != -1) {
            return dp[u];
        }
        int ans = 0;
        for (int[] v : graph.getOrDefault(u, new ArrayList<>())) {
            if (dist[v[0]] > dist[u]) {
                ans = (ans + dfs(v[0], n, graph, dist, dp)) % 1000000007;
            }
        }
        dp[u] = ans;
        return ans;
    }
}