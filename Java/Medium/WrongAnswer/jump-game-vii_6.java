class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        if (s.charAt(s.length() - 1) == '1') return false;
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                int start = Math.max(0, i - maxJump);
                int end = Math.max(0, i - minJump);
                if (start == 0 && dp[0]) {
                    dp[i] = true;
                    continue;
                }
                for (int j = start; j <= end; j++) {
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n - 1];
    }
}