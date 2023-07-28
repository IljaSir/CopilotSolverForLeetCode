class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }
        long[][][] dp = new long[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Long.MAX_VALUE;
                }
            }
        }
        dp[src1][src2][dest] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src1, src2, dest});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1], k = cur[2];
            if (graph.containsKey(i)) {
                for (int[] next : graph.get(i)) {
                    int x = next[0], w = next[1];
                    if (dp[x][j][k] > dp[i][j][k] + w) {
                        dp[x][j][k] = dp[i][j][k] + w;
                        queue.offer(new int[]{x, j, k});
                    }
                }
            }
            if (graph.containsKey(j)) {
                for (int[] next : graph.get(j)) {
                    int x = next[0], w = next[1];
                    if (dp[i][x][k] > dp[i][j][k] + w) {
                        dp[i][x][k] = dp[i][j][k] + w;
                        queue.offer(new int[]{i, x, k});
                    }
                }
            }
            if (graph.containsKey(k)) {
                for (int[] next : graph.get(k)) {
                    int x = next[0], w = next[1];
                    if (dp[i][j][x] > dp[i][j][k] + w) {
                        dp[i][j][x] = dp[i][j][k] + w;
                        queue.offer(new int[]{i, j, x});
                    }
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i
    }
}