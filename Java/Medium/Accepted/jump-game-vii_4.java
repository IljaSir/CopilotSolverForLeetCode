class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                cnt += dp[i - minJump] ? 1 : 0;
            }
            if (i > maxJump) {
                cnt -= dp[i - maxJump - 1] ? 1 : 0;
            }
            dp[i] = cnt > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}