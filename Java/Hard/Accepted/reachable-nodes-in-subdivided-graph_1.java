class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, x -> new HashMap<>()).put(v, w);
            graph.computeIfAbsent(v, x -> new HashMap<>()).put(u, w);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[] {0, maxMoves});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist.containsKey(cur[0])) continue;
            dist.put(cur[0], cur[1]);
            if (graph.containsKey(cur[0])) {
                for (int nei : graph.get(cur[0]).keySet()) {
                    int d = cur[1] - graph.get(cur[0]).get(nei) - 1;
                    if (!dist.containsKey(nei) && d >= 0) {
                        pq.offer(new int[] {nei, d});
                    }
                }
            }
        }
        int res = dist.size();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int du = dist.getOrDefault(u, 0);
            int dv = dist.getOrDefault(v, 0);
            res += Math.min(du + dv, w);
        }
        return res;
    }
}