class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int mod = 1000000007;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], -1);
        }
        for (int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 1});
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(ways, 0);
        dist[0] = 0;
        ways[0] = 1;
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int time = node[0], u = node[1], path = node[2];
            if (time > dist[u]) {
                continue;
            }
            for (int v = 0; v < n; v++) {
                if (graph[u][v] >= 0) {
                    int d = time + graph[u][v];
                    if (d < dist[v]) {
                        dist[v] = d;
                        ways[v] = path;
                        pq.offer(new int[] {d, v, ways[v]});
                    } else if (d == dist[v]) {
                        ways[v] = (ways[v] + path) % mod;
                    }
                }
            }
        }
        return ways[n - 1];
    }
}