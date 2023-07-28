class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == Integer.MAX_VALUE / 2) continue;
                int cnt = 0;
                for (int l = i; l < n; l++) {
                    if (s.charAt(l) == s.charAt(i)) cnt++;
                    if (j + l - i + 1 > k) break;
                    dp[l + 1][j + l - i + 1] = Math.min(dp[l + 1][j + l - i + 1], dp[i][j] + cnt + (cnt < 10 ? 1 : cnt < 100 ? 2 : 3));
                }
            }
        }
        int res = Integer.MAX_VALUE / 2;
        for (int i = 0; i <= k; i++) res = Math.min(res, dp[n][i]);
        return res;
    }
}