class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int[] adj = new int[n];
        for (int[] r : relations) {
            int u = r[0] - 1, v = r[1] - 1;
            adj[u] |= 1 << v;
        }
        for (int mask = 0; mask < (1 << n); mask++) {
            int avail = 0, taken = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    avail |= 1 << i;
                } else {
                    taken++;
                }
            }
            for (int i = 0; i < n; i++) {
                if ((avail & (1 << i)) == 0 || (adj[i] & mask) != adj[i]) {
                    continue;
                }
                int next = mask | (1 << i);
                dp[next] = Math.min(dp[next], dp[mask] + (taken % k == 0 ? 1 : 0));
            }
        }
        return dp[(1 << n) - 1];
    }
}