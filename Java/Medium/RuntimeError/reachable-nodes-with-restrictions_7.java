class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        
        int m = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            graph.computeIfAbsent(u, x -> new HashMap<>()).put(v, w);
            graph.computeIfAbsent(v, x -> new HashMap<>()).put(u, w);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0});
        boolean[] vis = new boolean[n];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            if (vis[u]) continue;
            vis[u] = true;
            if (!graph.containsKey(u)) continue;
            for (int v : graph.get(u).keySet()) {
                int w = graph.get(u).get(v);
                if (dist[v] > dist[u] + w + 1) {
                    dist[v] = dist[u] + w + 1;
                    pq.offer(new int[] {v, dist[v]});
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i] && Arrays.binarySearch(restricted, i) < 0) ans++;
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            int d1 = dist[u] < Integer.MAX_VALUE ? dist[u] : 0;
            int d2 = dist[v] < Integer.MAX_VALUE ? dist[v] : 0;
            ans += Math.min(w, d1 + d2);
            if (d1 < w) ans -= w - d1;
            if (d2 < w) ans -= w - d2;
        }
        return ans;
    }
}