class Solution {
    public int findIntegers(int n) {
        
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int res = 0;
        int k = 30;
        int pre = 0;
        while (k >= 0) {
            if (((n >> k) & 1) == 1) {
                res += dp[k];
                if (pre == 1) {
                    res--;
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }
            k--;
        }
        return res + 1;
    }
}