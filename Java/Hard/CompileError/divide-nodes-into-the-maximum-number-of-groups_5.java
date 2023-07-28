class Solution {
    public int magnificentSets(int n, int[][] edges) {
        
        int[] a = new int[n+1];
        int[] b = nedge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph[x] |= 1 << y;
            graph[y] |= 1 << x;
        }
        int m = 1 << n;
        int[] dp = new int[m];
        dp[0] = 1;
        for (int mask = 1; mask < m; mask++) {
            int u = Integer.numberOfTrailingZeros(mask);
            int submask = mask ^ (1 << u);
            int count = Integer.bitCount(submask);
            if (count > 1 && (submask & graph[u + 1]) == 0) {
                continue;
            }
            dp[mask] = dp[submask];
            for (int v = u + 1; v < n; v++) {
                if (((submask >> v) & 1) == 1 && (graph[v + 1] & mask) == 0) {
                    dp[mask] += dp[submask ^ (1 << v)];
                }
            }
        }
        return dp[m - 1];
    }
}