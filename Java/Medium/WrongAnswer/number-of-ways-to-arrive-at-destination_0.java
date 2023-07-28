class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int[][] graph = new int[n][n];
        for (int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];
            if (d > dist[u]) {
                continue;
            }
            for (int v = 0; v < n; ++v) {
                if (graph[u][v] > 0) {
                    int d2 = d + graph[u][v];
                    if (d2 < dist[v]) {
                        dist[v] = d2;
                        ways[v] = ways[u];
                        pq.offer(new int[]{d2, v});
                    } else if (d2 == dist[v]) {
                        ways[v] = (ways[v] + ways[u]) % 1000000007;
                    }
                }
            }
        }
        return ways[n - 1];
    }
}