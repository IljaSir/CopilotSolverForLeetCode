class Solution {
    public int minScore(int n, int[][] roads) {
        
        // Dijkstra's Algorithm
        // O(n + mlogn) time complexity, O(n + m) space complexity
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.putIfAbsent(road[0], new HashMap<>());
            graph.putIfAbsent(road[1], new HashMap<>());
            graph.get(road[0]).put(road[1], road[2]);
            graph.get(road[1]).put(road[0], road[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (dist.containsKey(curr[0])) {
                continue;
            }
            dist.put(curr[0], curr[1]);
            if (curr[0] == n) {
                break;
            }
            for (Map.Entry<Integer, Integer> neighbor : graph.getOrDefault(curr[0], new HashMap<>()).entrySet()) {
                if (!dist.containsKey(neighbor.getKey())) {
                    pq.offer(new int[]{neighbor.getKey(), Math.max(curr[1], neighbor.getValue())});
                }
            }
        }
        return dist.get(n);
    }
}