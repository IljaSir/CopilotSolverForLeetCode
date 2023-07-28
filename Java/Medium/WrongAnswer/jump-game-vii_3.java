class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                sum -= dp[i - minJump];
            }
            if (i > maxJump) {
                sum += dp[i - maxJump - 1];
            }
            if (s.charAt(i) == '0' && sum > 0) {
                dp[i] = 1;
            }
        }
        return dp[n - 1] == 1;
    }
}