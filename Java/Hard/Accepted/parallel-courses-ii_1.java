class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] pre = new int[n];
        for (int[] r : relations) {
            pre[r[1] - 1] |= 1 << (r[0] - 1);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            int canTake = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0 && (i & pre[j]) == pre[j]) {
                    canTake |= 1 << j;
                }
            }
            for (int c = canTake; c > 0; c = (c - 1) & canTake) {
                if (Integer.bitCount(c) <= k) {
                    dp[i | c] = Math.min(dp[i | c], dp[i] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}