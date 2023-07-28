class Solution {
    public int minimumNumbers(int num, int k) {
        
        int[] dp = new int[10];
        dp[0] = 0;
        for (int i = 1; i < 10; i++) {
            dp[i] = num - i;
        }
        for (int i = 1; i < 10; i++) {
            if (dp[i] < 0) {
                return -1;
            }
            if (dp[i] % 9 == 0) {
                dp[i] /= 9;
            } else {
                dp[i] = dp[i] / 9 + 1;
            }
        }
        return dp[k];
    }
}