class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        long[] dist1 = dijkstra(graph, src1);
        long[] dist2 = dijkstra(graph, src2);
        long[] dist3 = dijkstra(graph, dest);
        long min = Long.MAX_VALUE;
        for (int[] edge : edges) {
            long sum = dist1[edge[0]] + dist2[edge[0]] + dist3[edge[1]] + edge[2];
            if (sum < min) {
                min = sum;
            }
        }
        return min < Long.MAX_VALUE ? min : -1;
    }
    private long[] dijkstra(List<int[]>[] graph, int src) {
        long[] dist = new long[graph.length];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] > dist[curr[0]]) {
                continue;
            }
            for (int[] nei : graph[curr[0]]) {
                if (curr[1] + nei[1] < dist[nei[0]]) {
                    dist[nei[0]] = curr[1] + nei[1];
                    pq.offer(new int[]{nei[0], (int)dist[nei[0]]});
                }
            }
        }
        return dist;
    }
}