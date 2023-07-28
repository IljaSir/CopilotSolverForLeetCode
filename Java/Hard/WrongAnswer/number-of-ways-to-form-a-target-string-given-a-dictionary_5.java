class Solution {
    public int numWays(String[] words, String target) {
        
        int mod = 1000000007;
        int n = words[0].length();
        int m = target.length();
        int[][] count = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= n; j++) {
                if (count[j - 1][target.charAt(i - 1) - 'a'] == 0) {
                    continue;
                }
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * count[j - 1][target.charAt(i - 1) - 'a']) % mod;
                dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
            }
        }
        return dp[m][n];
    }
}