class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new HashMap<>());
            graph.putIfAbsent(e[1], new HashMap<>());
            graph.get(e[0]).put(e[1], e[2]);
            graph.get(e[1]).put(e[0], e[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], node = top[1];
            if (d > dist[node]) continue;
            for (int nei : graph.getOrDefault(node, new HashMap<>()).keySet()) {
                int d2 = d + graph.get(node).get(nei) + 1;
                if (d2 < dist[nei]) {
                    pq.offer(new int[]{d2, nei});
                    dist[nei] = d2;
                }
            }
        }
        int res = 0;
        for (int d : dist) {
            if (d <= maxMoves) res++;
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            int d1 = dist[u] == Integer.MAX_VALUE ? 0 : dist[u];
            int d2 = dist[v] == Integer.MAX_VALUE ? 0 : dist[v];
            res += Math.max(0, Math.min(cnt, cnt - (d1 + d2 - maxMoves)));
        }
        return res;
    }
}