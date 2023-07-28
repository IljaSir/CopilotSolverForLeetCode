class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] pre = new int[n];
        int[] next = new int[n];
        for (int[] r: relations) {
            pre[r[1] - 1] |= (1 << (r[0] - 1));
            next[r[0] - 1] |= (1 << (r[1] - 1));
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0 && (mask & pre[i]) == pre[i]) {
                    temp |= (1 << i);
                }
            }
            for (int sub = temp; sub > 0; sub = (sub - 1) & temp) {
                if (Integer.bitCount(sub) <= k) {
                    dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}