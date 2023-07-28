class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        int n = vals.length;
        int[] dp = new int[n];
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i] = vals[i];
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && dp[j] > dp[max]) {
                    max = j;
                }
            }
            next[i] = max;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                cur[j] = dp[j];
            }
            int count = 0;
            int sum = 0;
            int j = i;
            while (j >= 0 && count <= k) {
                sum += cur[j];
                cur[j] = 0;
                j = next[j];
                count++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}