class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = -1;
            }
        }
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int node = poll[0];
            int distance = poll[1];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            for (int i = 1; i <= n; i++) {
                if (graph[node][i] != -1) {
                    int newDistance = distance + graph[node][i];
                    if (newDistance < dist[i]) {
                        dist[i] = newDistance;
                        queue.add(new int[]{i, newDistance});
                    }
                }
            }
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 1;
        return (int) dfs(1, n, graph, dist, dp);
    }

    private long dfs(int node, int n, int[][] graph, int[] dist, long[] dp) {
        if (dp[node] != -1) {
            return dp[node];
        }
        long count = 0;
        for (int i = 1; i <= n; i++) {
            if (graph[node][i] != -1 && dist[i] > dist[node]) {
                count += dfs(i, n, graph, dist, dp);
                count %= 1000000007;
            }
        }
        dp[node] = count;
        return count;
    }
}