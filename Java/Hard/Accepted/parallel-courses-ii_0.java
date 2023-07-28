class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] pre = new int[n];
        for (int[] r : relations) {
            pre[r[1] - 1] |= 1 << (r[0] - 1);
        }
        int[] dp = new int[1 << n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = n;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            int canTake = 0;
            for (int j = 0; j < n; j++) {
                if ((pre[j] & i) == pre[j]) {
                    canTake |= 1 << j;
                }
            }
            canTake &= ~i;
            for (int j = canTake; j > 0; j = (j - 1) & canTake) {
                if (Integer.bitCount(j) <= k) {
                    dp[i | j] = Math.min(dp[i | j], dp[i] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}