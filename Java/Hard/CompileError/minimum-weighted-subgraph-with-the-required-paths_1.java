class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        long[][] dist = new long[3][n];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        dist[0][src1] = 0;
        dist[1][src2] = 0;
        dist[2][dest] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new int[]{src1, 0});
        pq.offer(new int[]{src2, 0});
        pq.offer(new int[]{dest, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            long d = cur[1];
            if (d > dist[0][u] || d > dist[1][u] || d > dist[2][u]) {
                continue;
            }
            if (graph.containsKey(u)) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    long w = edge[1];
                    if (d + w < dist[0][v]) {
                        dist[0][v] = d + w;
                        pq.offer(new int[]{v, dist[0][v]});
                    }
                    if (d + w < dist[1][v]) {
                        dist[1][v] = d + w;
                        pq.offer(new int[]{v, dist[1][v]});
                    }
                    if (d + w < dist[2][v]) {
                        dist[2][v] = d + w;
                        pq.offer(new int[]{v, dist[2][v]});
                    }
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist[0][i] != Long.MAX_VALUE && dist[1][i] != Long.MAX_VALUE && dist[2][i] != Long.MAX_VALUE) {
                res = Math.min(res, dist[0][
    }
}