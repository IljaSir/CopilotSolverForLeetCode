class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new HashMap<Integer, Integer>());
            graph.get(edge[0]).put(edge[1], edge[2]);
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        boolean[] visited = new boolean[n+1];
        for (int count=0; count<n; count++) {
            int u = -1;
            for (int i=1; i<=n; i++) {
                if (!visited[i] && (u==-1 || dist[i] < dist[u]))
                    u = i;
            }
            visited[u] = true;
            if (graph.containsKey(u)) {
                for (int v : graph.get(u).keySet()) {
                    dist[v] = Math.min(dist[v], dist[u] + graph.get(u).get(v));
                }
            }
        }
        int ans = 0;
        for (int i=1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}