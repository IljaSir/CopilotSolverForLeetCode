class Solution {
    public int distinctIntegers(int n) {
        
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 1) {
                    dp[i]++;
                }
            }
            ans += dp[i];
        }
        return ans;
    }
}