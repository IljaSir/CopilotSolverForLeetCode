class Solution {
    public int numberWays(List<List<Integer>> hats) {
        
        int mod = 1000000007;
        int n = hats.size();
        int[] dp = new int[1<<n];
        dp[0] = 1;
        int[] last = new int[41];
        for (int i = 0; i < 41; i++) {
            last[i] = -1;
        }
        for (int i = 1; i <= 40; i++) {
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if (hats.get(j).contains(i)) {
                    mask |= (1<<j);
                }
            }
            for (int j = (1<<n)-1; j >= 0; j--) {
                if (dp[j] > 0) {
                    dp[j|mask] = (dp[j|mask] + dp[j]) % mod;
                }
            }
        }
        return dp[(1<<n)-1];
    }
}