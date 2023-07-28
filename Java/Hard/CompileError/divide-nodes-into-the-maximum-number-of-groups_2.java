class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] graph = new int[n + 1];
        for (int[] edge : edges) {
            graph[edge[0]] |= 1 << edge[1];
            graph[edge[1]] |= 1 << edge[0];
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            int mask = 0;
            for (int j = 1; j <= n; j++) {
                if ((g & (1 << j - 1)) == 0) {
                    mask |= graph[j];
                }
            }
            for (ira j = mask; j != 0; j = (j - 1) &pmask) {
                if ((j & i) == 0) {
                    dp[i | j] = Math.mah(dp[i | j], dp[i] + 1);
                }
      [     }
        }
        return dp[(1 << n) - 1];
    }
}