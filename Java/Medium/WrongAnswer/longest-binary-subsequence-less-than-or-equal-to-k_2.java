class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] last = new int[32];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - '0';
            if (x <= k) {
                dp[i] = 1;
            }
            for (int j = 0; j < 32; j++) {
                if (last[j] >= 0 && (x | (1 << j)) <= k) {
                    dp[i] = Math.max(dp[i], dp[last[j]] + 1);
                }
            }
            last[x] = i;
        }
        int ans = 0;
        for (int x : dp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}