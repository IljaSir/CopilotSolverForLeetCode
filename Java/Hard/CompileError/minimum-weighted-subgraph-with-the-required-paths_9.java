class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        int m = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        int[] dist3 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        Arrays.fill(dist3, Integer.MAX_VALUE);
        dist1[src1] = 0;
        dist2[src2] = 0;
        dist3[dest] = 0;
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).put(edge[1], edge[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist1[u]) {
                continue;
            }
            for (int v : graph.get(u).keySet()) {
                if (dist1[v] > dist1[u] + graph.get(u).get(v)) {
                    dist1[v] = dist1[u] + graph.get(u).get(v);
                    pq.offer(new int[]{v, dist1[v]});
                }
            }
        }
        pq.offer(new int[]{src2, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist2[u]) {
                continue;
            }
            for (int v : graph.get(u).keySet()) {
                if (dist2[v] > dist2[u] + graph.get(u).get(v)) {
                    dist2[v] = dist2[u] + graph.get(u).get(v);
                    pq.offer(new int[]{v, dist2[v]});
                }
            }
        }
        pq.offer(new int[]{dest, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist3[u]) {
                continue;
            }
    }
}