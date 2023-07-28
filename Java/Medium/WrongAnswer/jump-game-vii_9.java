class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        int n = s.length();
        if (s.charAt(n - 1) == '1') {
            return false;
        }
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int[] sum = new int[n];
        sum[0] = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                continue;
            }
            if (i - minJump >= 0) {
                int l = Math.max(0, i - maxJump);
                int r = i - minJump;
                if (sum[r] - (l > 0 ? sum[l - 1] : 0) > 0) {
                    dp[i] = true;
                }
            }
            sum[i] = sum[i - 1] + (dp[i] ? 1 : 0);
        }
        return dp[n - 1];
    }
}