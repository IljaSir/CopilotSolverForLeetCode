class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new HashMap<>()).put(e[1], e[2]);
            graph.computeIfAbsent(e[1], k -> new HashMap<>()).put(e[0], e[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] > dist[cur[0]]) continue;
            for (int next : graph.getOrDefault(cur[0], new HashMap<>()).keySet()) {
                int d = cur[1] + graph.get(cur[0]).get(next) + 1;
                if (d < dist[next]) {
                    dist[next] = d;
                    pq.offer(new int[]{next, d});
                }
            }
        }
        int res = 0;
        for (int d : dist) {
            if (d <= maxMoves) res++;
        }
        for (int[] e : edges) {
            int d1 = dist[e[0]] > maxMoves ? 0 : maxMoves - dist[e[0]];
            int d2 = dist[e[1]] > maxMoves ? 0 : maxMoves - dist[e[1]];
            res += Math.min(d1 + d2, e[2]);
        }
        return res;
    }
}