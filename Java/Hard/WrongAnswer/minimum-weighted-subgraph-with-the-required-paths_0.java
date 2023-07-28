class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }
        long[] dist1 = dijkstra(graph, src1, n);
        long[] dist2 = dijkstra(graph, src2, n);
        long[] dist3 = dijkstra(graph, dest, n);
        long min = Long.MAX_VALUE;
        for (int[] edge : edges) {
            long d1 = dist1[edge[0]];
            long d2 = dist2[edge[0]];
            long d3 = dist3[edge[1]];
            if (d1 != Long.MAX_VALUE && d2 != Long.MAX_VALUE && d3 != Long.MAX_VALUE) {
                min = Math.min(min, d1 + d2 + d3 + edge[2]);
            }
        }
        return min == Long.MAX_VALUE ? -1 : min;
    }
    private long[] dijkstra(Map<Integer, List<int[]>> graph, int src, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[src] = 0;
        pq.add(new int[] {src, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            for (int[] next : graph.get(u)) {
                int v = next[0];
                int w = next[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[] {v, (int) dist[v]});
                }
            }
        }
        return dist;
    }
}