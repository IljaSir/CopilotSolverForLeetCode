class Solution {
    public int largestVariance(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = (s.charAt(i) - 'a' == j ? 1 : 0) + (i > 0 ? dp[i - 1][j] : 0);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int max = 0, min = j - i + 1;
                for (int k = 0; k < 26; k++) {
                    int cnt = dp[j][k] - (i > 0 ? dp[i - 1][k] : 0);
                    max = Math.max(max, cnt);
                    min = Math.min(min, cnt);
                }
                ans = Math.max(ans, max - min);
            }
        }
        return ans;
    }
}