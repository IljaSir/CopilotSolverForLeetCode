class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(e[0], k -> new ArrayList<>()).add(new int[]{e[1], e[2]});
            graph.computeIfAbsent(e[1], k -> new ArrayList<>()).add(new int[]{e[0], e[2]});
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int d = cur[1];
            if (d > dist[node]) continue;
            for (int[] next : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = next[0];
                int nextDist = d + next[1];
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.add(new int[]{nextNode, nextDist});
                }
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(1, n, graph, dist, dp);
    }
    private int dfs(int node, int n, Map<Integer, List<int[]>> graph, int[] dist, int[] dp) {
        if (node == n) return 1;
        if (dp[node] != -1) return dp[node];
        int res = 0;
        for (int[] next : graph.getOrDefault(node, new ArrayList<>())) {
            int nextNode = next[0];
            if (dist[node] > dist[nextNode]) {
                res = (res + dfs(nextNode, n, graph, dist, dp)) % 1000000007;
            }
        }
        dp[node] = res;
        return res;
    }
}