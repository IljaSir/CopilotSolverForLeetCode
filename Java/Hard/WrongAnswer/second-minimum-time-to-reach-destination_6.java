class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], time});
            graph.get(edge[1]).add(new int[]{edge[0], time});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            if (d > dist[u]) {
                continue;
            }
            for (int[] next : graph.get(u)) {
                int v = next[0];
                int w = next[1];
                int nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new int[]{v, nd});
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 2; i <= n; i++) {
            int d = dist[i];
            int r = d % (2 * change);
            if (r > change) {
                d += 2 * change - r;
            }
            res = Math.min(res, d);
        }
        return res;
    }
}