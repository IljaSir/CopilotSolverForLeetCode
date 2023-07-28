class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int pre = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                pre += dp[i - minJump] ? 1 : 0;
            }
            if (i > maxJump) {
                pre -= dp[i - maxJump - 1] ? 1 : 0;
            }
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}