class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        
        int[] dist = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    parent[v] = u;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + 1 < dist[v]) {
                int cycleLength = dist[u] + 1 + dist[v];
                min = Math.min(cycleLength, min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}