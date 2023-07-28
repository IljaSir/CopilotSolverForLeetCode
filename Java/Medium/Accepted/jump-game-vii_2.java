class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        if (s.charAt(s.length() - 1) != '0') {
            return false;
        }
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int left = 0;
        int right = 0;
        for (int i = 1; i < n; i++) {
            if (i >= minJump) {
                left += dp[i - minJump] ? 1 : 0;
            }
            if (i > maxJump) {
                left -= dp[i - maxJump - 1] ? 1 : 0;
            }
            dp[i] = s.charAt(i) == '0' && left > 0;
        }
        return dp[n - 1];
    }
}