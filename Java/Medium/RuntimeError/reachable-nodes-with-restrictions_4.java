class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (dist[v] == Integer.MAX_VALUE) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }
        int ans = 0;
        for (int r : restricted) {
            if (dist[r] != Integer.MAX_VALUE) {
                ans++;
            }
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist[u] == Integer.MAX_VALUE && dist[v] == Integer.MAX_VALUE) {
                continue;
            }
            if (dist[u] == Integer.MAX_VALUE) {
                ans += Math.min(w, dist[v]);
            } else if (dist[v] == Integer.MAX_VALUE) {
                ans += Math.min(w, dist[u]);
            } else {
                ans += Math.min(w, dist[u] + dist[v]);
                ans += Math.min(w - dist[u] - dist[v], 0);
            }
        }
        return ans;
    }
}