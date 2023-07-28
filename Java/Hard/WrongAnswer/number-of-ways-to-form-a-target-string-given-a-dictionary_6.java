class Solution {
    public int numWays(String[] words, String target) {
        
        int m = words.length, n = words[0].length(), t = target.length();
        int[][] cnt = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                cnt[i][word.charAt(i) - 'a']++;
            }
        }
        int[][] dp = new int[t + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 0; i < t; i++) {
            for (int j = i; j < n; j++) {
                dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i + 1][j]) % 1000000007;
                dp[i + 1][j + 1] = (dp[i + 1][j + 1] + (int)((long)dp[i][j] * cnt[j][target.charAt(i) - 'a'] % 1000000007)) % 1000000007;
            }
        }
        return dp[t][n];
    }
}