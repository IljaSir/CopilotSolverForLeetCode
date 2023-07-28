class Solution {
    public int distinctSubseqII(String s) {
        
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i)-'a';
            dp[i+1] = (2*dp[i])%1000000007;
            if (last[x] > 0) {
                dp[i+1] -= dp[last[x]-1];
            }
            dp[i+1] %= 1000000007;
            last[x] = i+1;
        }
        dp[s.length()]--;
        if (dp[s.length()] < 0) {
            dp[s.length()] += 1000000007;
        }
        return dp[s.length()];
    }
}