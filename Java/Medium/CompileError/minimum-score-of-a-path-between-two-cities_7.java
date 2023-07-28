class Solution {
    public int minScore(int n, int[][] roads) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            int[] road = roads[i];
            List<int[]> list = graph.getOrDefault(road[0], new ArrayList<>());
            list.add(new int[]{road[1], road[2]});
            graph.put(road[0], list);
            list = graph.getOrDefault(road[1], new ArrayList<>());
            list.add(new int[]{road[0], road[2]});
            graph.put(road[1], list);
        }
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i, 0});
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int u = node[0];
                int d = node[1];
                for (int[] edge : graph.getOrDefault(u, new ArrayList<>())) {
                    int v = edge[0];
                    int w = edge[1];
                    if (d + w < dist[i][v]) {
                        dist[i][v] = d + w;
                        queue.offer(new int[]{v, dist[i][v]});
                    }
                }
            }
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                for (int k = j; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j], dist[k + 1][i]));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        return
    }
}