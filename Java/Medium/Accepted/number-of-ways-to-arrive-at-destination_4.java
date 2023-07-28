class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int[][] graph = new int[n][n];
        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph[u][v] = w;
            graph[v][u] = w;
        }
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[1], d = cur[0];
            if (d > dist[u]) {
                continue;
            }
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0) {
                    int newDist = d + graph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        ways[v] = ways[u];
                        pq.offer(new int[]{newDist, v});
                    } else if (newDist == dist[v]) {
                        ways[v] = (ways[v] + ways[u]) % 1000000007;
                    }
                }
            }
        }
        return ways[n - 1];
    }
}