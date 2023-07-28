class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        int mod = 1000000007;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[] {e[1], e[2]});
            graph.get(e[1]).add(new int[] {e[0], e[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {n, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (d > dist[u]) {
                continue;
            }
            for (int[] v : graph.get(u)) {
                if (dist[v[0]] > d + v[1]) {
                    dist[v[0]] = d + v[1];
                    pq.offer(new int[] {v[0], dist[v[0]]});
                }
            }
        }
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 1; i--) {
            for (int[] v : graph.get(i)) {
                if (dist[i] > dist[v[0]]) {
                    dp[i] = (dp[i] + dp[v[0]]) % mod;
                }
            }
        }
        return dp[1];
    }
}