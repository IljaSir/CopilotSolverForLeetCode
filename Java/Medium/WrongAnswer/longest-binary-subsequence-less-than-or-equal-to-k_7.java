class Solution {
    public int longestSubsequence(String s, int k) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] sum = new int[n + 1];
        int[] pos = new int[n + 1];
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + (s.charAt(i) - '0');
            sum[i + 1] = sum[i] + (s.charAt(i) - '0') * (1 << (n - i - 1));
            if (pos[dp[i + 1]] == -1) {
                pos[dp[i + 1]] = i;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i + 1] <= k) {
                ans = Math.max(ans, i + 1);
            }
            for (int j = 0; j <= i; j++) {
                int x = dp[i + 1] - dp[j];
                int y = sum[i + 1] - sum[j];
                if (y <= k && pos[x] >= j) {
                    ans = Math.max(ans, i - j);
                }
            }
        }
        return ans;
    }
}