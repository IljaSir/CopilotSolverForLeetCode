class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        
        int n = patience.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == Integer.MAX_VALUE) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int d = dist[i];
            int p = patience[i];
            ans = Math.max(ans, (d + p - 1) / p * p + d);
        }
        return ans;
    }
}