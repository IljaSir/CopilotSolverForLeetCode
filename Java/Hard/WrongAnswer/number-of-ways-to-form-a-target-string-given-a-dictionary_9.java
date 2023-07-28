class Solution {
    public int numWays(String[] words, String target) {
        
        int n = words.length, m = words[0].length(), mod = (int)1e9+7;
        int[][] count = new int[m][26];
        for (String word : words) {
            for (int i = 0; i < m; ++i) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        int[][] dp = new int[m][target.length()];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < target.length(); ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = count[i][target.charAt(j) - 'a'];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] * count[i][target.charAt(j) - 'a'] % mod;
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] * count[i][target.charAt(j) - 'a'] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j] * count[i][target.charAt(j) - 'a'] % mod + dp[i - 1][j - 1] * count[i][target.charAt(j) - 'a'] % mod) % mod;
                }
            }
        }
        return dp[m - 1][target.length() - 1];
    }
}