class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph.computeIfAbsent(from, k -> new HashMap<>()).put(to, weight);
        }
        // [node, weight]
        Map<Integer, Integer> dist1 = dijkstra(graph, src1);
        Map<Integer, Integer> dist2 = dijkstra(graph, src2);
        Map<Integer, Integer> dist3 = dijkstra(graph, dest);
        long result = Long.MAX_VALUE;
        for (int node : dist1.keySet()) {
            if (dist2.containsKey(node) && dist3.containsKey(node)) {
                result = Math.min(result, (long) dist1.get(node) + dist2.get(node) + dist3.get(node));
            }
        }
        return result == Long.MAX_VALUE ? -1 : result;
    }

    private Map<Integer, Integer> dijkstra(Map<Integer, Map<Integer, Integer>> graph, int src) {
        Map<Integer, Integer> dist = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {src, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int weight = cur[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, weight);
            if (!graph.containsKey(node)) continue;
            for (int next : graph.get(node).keySet()) {
                pq.offer(new int[] {next, weight + graph.get(node).get(next)});
            }
        }
        return dist;
    }
}