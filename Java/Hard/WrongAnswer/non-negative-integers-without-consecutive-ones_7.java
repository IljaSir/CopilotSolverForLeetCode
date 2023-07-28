class Solution {
    public int findIntegers(int n) {
        
        int[][] dp = new int[32][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < 32; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        int i = 30, pre = 0, res = 0;
        while (i >= 0) {
            if (((n >> i) & 1) == 1) {
                res += dp[i][0] + dp[i][1];
                if (pre == 1) {
                    res -= dp[i][1];
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
            i--;
        }
        return res + 1;
    }
}