class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[]{edge[0], edge[2]});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{n, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];
            if (d > dist[node]) continue;
            for (int[] nei : graph.get(node)) {
                int neiNode = nei[0], neiDist = nei[1];
                if (dist[neiNode] > d + neiDist) {
                    dist[neiNode] = d + neiDist;
                    pq.offer(new int[]{neiNode, d + neiDist});
                }
            }
        }
        
        int[] dp = new int[n + 1];
        dp[n] = 1;
        pq.offer(new int[]{n, dist[n]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];
            if (d < dist[node]) continue;
            for (int[] nei : graph.get(node)) {
                int neiNode = nei[0], neiDist = nei[1];
                if (dist[neiNode] > dist[node]) {
                    dp[neiNode] = (dp[neiNode] + dp[node]) % 1000000007;
                    pq.offer(new int[]{neiNode, dist[neiNode]});
                }
            }
        }
        
        return dp[1];
    }
}