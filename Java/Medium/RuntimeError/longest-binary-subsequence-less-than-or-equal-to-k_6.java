class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n];
        int[] next = new int[n];
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
            prev[i] = i - 1;
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                dp[i] = 1;
                if (i > 0) {
                    dp[i] += dp[prev[i]];
                    next[prev[i]] = next[i];
                    prev[next[i]] = prev[i];
                }
            }
        }
        int max = 0;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                pos = i;
            }
        }
        int ans = 0;
        while (pos >= 0 && k > 0) {
            if (s.charAt(pos) == '0') {
                ans++;
                k--;
            } else {
                ans++;
            }
            pos = prev[pos];
        }
        return ans;
    }
}