class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
        long[] dist1 = dijkstra(graph, src1);
        long[] dist2 = dijkstra(graph, src2);
        long[] dist3 = dijkstra(graph, dest);
        long res = Long.MAX_VALUE;
        for (int[] edge : edges) {
            if (dist1[edge[0]] != Long.MAX_VALUE && dist2[edge[0]] != Long.MAX_VALUE && dist3[edge[1]] != Long.MAX_VALUE) {
                res = Math.min(res, dist1[edge[0]] + dist2[edge[0]] + dist3[edge[1]] + edge[2]);
            }
            if (dist1[edge[1]] != Long.MAX_VALUE && dist2[edge[1]] != Long.MAX_VALUE && dist3[edge[0]] != Long.MAX_VALUE) {
                res = Math.min(res, dist1[edge[1]] + dist2[edge[1]] + dist3[edge[0]] + edge[2]);
            }
        }
        return res == Long.MAX_VALUE ? -1 : res;
    }
    
    private long[] dijkstra(Map<Integer, List<int[]>> graph, int src) {
        long[] dist = new long[graph.size()];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist[cur[0]] < cur[1]) {
                continue;
            }
            for (int[] next : graph.getOrDefault(cur[0], new ArrayList<>())) {
                if (dist[next[0]] > cur[1] + next[1]) {
                    dist[next[0]] = cur[1] + next[1];
                    pq.offer(new int[]{next[0], (int)dist[next[0]]});
                }
            }
        }
        return dist;
    }
}