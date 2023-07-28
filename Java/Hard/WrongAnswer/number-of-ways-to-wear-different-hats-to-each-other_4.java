class Solution {
    public int numberWays(List<List<Integer>> hats) {
        
        int mod = 1000000007;
        int n = hats.size();
        int m = 40;
        int[][] dp = new int[n + 1][1 << n];
        dp[0][0] = 1;
        int[] last = new int[41];
        Arrays.fill(last, -1);
        for (int j = 0; j < m; j++) {
            int mask = 0;
            for (int i = 0; i < n; i++) {
                if (hats.get(i).contains(j + 1)) {
                    mask |= (1 << i);
                }
            }
            for (int i = n; i >= 1; i--) {
                for (int k = 0; k < (1 << n); k++) {
                    if ((k & mask) != 0) {
                        dp[i][k] = (dp[i][k] + dp[i - 1][k ^ mask]) % mod;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + dp[i][(1 << n) - 1]) % mod;
        }
        return res;
    }
}