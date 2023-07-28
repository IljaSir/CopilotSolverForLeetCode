class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        
        int n = scores.length;
        int[] dp = new int[1 << n];
        int[] sum = new int[1 << n];
        int[] indegree = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            indegree[u]++;
            indegree[v]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                dp[1 << i] = scores[i];
            }
        }
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    sum[mask] = sum[mask ^ (1 << i)] + scores[i];
                    break;
                }
            }
        }
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    for (int j = i + 1; j < n; j++) {
                        if (((mask >> j) & 1) == 1) {
                            for (int[] e : edges) {
                                int u = e[0], v = e[1];
                                if ((u == i && v == j) || (u == j && v == i)) {
                                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << i) ^ (1 << j)] + sum[mask]);
                                }
                            }
                        }
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}