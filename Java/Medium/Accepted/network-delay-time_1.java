class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v, w});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int node = 1; node <= n; ++node)
            dist.put(node, Integer.MAX_VALUE);

        dist.put(k, 0);
        boolean[] seen = new boolean[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int d = info[0], node = info[1];
            seen[node] = true;
            if (d > dist.get(node)) continue;
            for (int[] edge : graph.getOrDefault(node, new ArrayList<>())) {
                int nei = edge[0], d2 = edge[1];
                if (seen[nei]) continue;
                if (dist.get(node) + d2 < dist.get(nei)) {
                    dist.put(nei, dist.get(node) + d2);
                    pq.offer(new int[]{dist.get(nei), nei});
                }
            }
        }

        int ans = 0;
        for (int cand : dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}