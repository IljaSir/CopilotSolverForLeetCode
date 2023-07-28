class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            int[] dist = new int[n];
            Arrays.fill(dist, -1);
            dist[i] = 0;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int nei : graph.get(cur)) {
                    if (dist[nei] == -1) {
                        dist[nei] = dist[cur] + 1;
                        queue.offer(nei);
                    } else if (dist[nei] >= dist[cur]) {
                        res = Math.min(res, dist[nei] + dist[cur] + 1);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}