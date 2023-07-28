class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] last = new int[32];
        Arrays.fill(last, -1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            int m = 0;
            for (int j = 1; j <= 30; j++) {
                if (j > c) {
                    if (j - c <= k) {
                        m = Math.max(m, dp[last[j - c]] + 1);
                    }
                } else if (j == c) {
                    m = Math.max(m, 1);
                }
            }
            if (c <= k) {
                m = Math.max(m, 1);
            }
            dp[i] = m;
            ans = Math.max(ans, m);
            last[c] = i;
        }
        return ans;
    }
}