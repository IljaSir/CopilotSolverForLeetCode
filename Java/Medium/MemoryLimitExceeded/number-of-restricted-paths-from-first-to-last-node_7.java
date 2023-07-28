class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
            graph[u][v] = graph[v][u] = w;
        }

        int[] dist = dijkstra(graph, n, n - 1);
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        return (int) dfs(graph, 0, n - 1, dist, dp);
    }

    private long dfs(int[][] graph, int cur, int n, int[] dist, long[] dp) {
        if (cur == n) return 1;
        if (dp[cur] != -1) return dp[cur];
        dp[cur] = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[cur][i] != 0 && dist[cur] > dist[i]) {
                dp[cur] += dfs(graph, i, n, dist, dp);
                dp[cur] %= 1000000007;
            }
        }
        return dp[cur];
    }

    private int[] dijkstra(int[][] graph, int n, int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            for (int i = 0; i < n; i++) {
                if (graph[curNode][i] != 0) {
                    int newDist = dist[curNode] + graph[curNode][i];
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        pq.offer(new int[]{i, newDist});
                    }
                }
            }
        }
        return dist;
    }
}