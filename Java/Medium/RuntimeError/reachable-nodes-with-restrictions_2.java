class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new HashMap<>());
            graph.putIfAbsent(e[1], new HashMap<>());
            graph.get(e[0]).put(e[1], e[2]);
            graph.get(e[1]).put(e[0], e[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(0, 0);
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (dist.get(cur[0]) < cur[1]) continue;
            for (int nei : graph.getOrDefault(cur[0], new HashMap<>()).keySet()) {
                int d = cur[1] + graph.get(cur[0]).get(nei) + 1;
                if (d > dist.getOrDefault(nei, 0)) {
                    dist.put(nei, d);
                    pq.offer(new int[]{nei, d});
                }
            }
        }
        int res = dist.size();
        for (int[] e : edges) {
            int a = dist.getOrDefault(e[0], 0);
            int b = dist.getOrDefault(e[1], 0);
            res += Math.min(a + b, e[2]);
        }
        for (int r : restricted) {
            if (dist.containsKey(r)) res--;
        }
        return res;
    }
}