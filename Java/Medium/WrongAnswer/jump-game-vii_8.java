class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        int n = s.length();
        if (s.charAt(n-1) == '1') return false;
        if (n == 1) return true;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int l = Math.max(0, i - maxJump);
            int r = Math.max(0, i - minJump);
            if (l > 0) sum -= dp[l-1] ? 1 : 0;
            sum += dp[r] ? 1 : 0;
            dp[i] = sum > 0 && s.charAt(i) == '0';
        }
        return dp[n-1];
    }
}