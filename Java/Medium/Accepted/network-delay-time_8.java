class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // Build the graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashMap<>());
            }
            graph.get(edge[0]).put(edge[1], edge[2]);
        }
        // A priority queue to sort the edges
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        Map<Integer, Integer> dist = new HashMap<>();
        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int time = edge[0], node = edge[1];
            if (dist.containsKey(node)) {
                continue;
            }
            dist.put(node, time);
            if (graph.containsKey(node)) {
                for (int nei : graph.get(node).keySet()) {
                    pq.offer(new int[]{time + graph.get(node).get(nei), nei});
                }
            }
        }
        // If there is no solution
        if (dist.size() != n) {
            return -1;
        }
        // Find the maximum distance
        int ans = 0;
        for (int cand : dist.values()) {
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}