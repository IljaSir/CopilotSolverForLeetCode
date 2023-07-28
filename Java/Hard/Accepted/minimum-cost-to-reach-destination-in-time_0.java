class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        
        int n = passingFees.length;
        int[][] dp = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = passingFees[0];
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, passingFees[0]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], t = cur[1], cost = cur[2];
            if (u == n - 1) {
                return cost;
            }
            if (dp[u][t] < cost) {
                continue;
            }
            for (int[] nxt : graph.getOrDefault(u, new ArrayList<>())) {
                int v = nxt[0], w = nxt[1];
                if (t + w <= maxTime && cost + passingFees[v] < dp[v][t + w]) {
                    dp[v][t + w] = cost + passingFees[v];
                    pq.offer(new int[]{v, t + w, dp[v][t + w]});
                }
            }
        }
        return -1;
    }
}