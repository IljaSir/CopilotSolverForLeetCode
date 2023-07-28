class Solution {
    public int numWays(String[] words, String target) {
        
        int mod = 1000000007;
        int[][] count = new int[words[0].length()][26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        int[][] dp = new int[target.length() + 1][words[0].length() + 1];
        for (int i = 0; i <= words[0].length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= target.length(); i++) {
            for (int j = i; j <= words[0].length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (count[j - 1][target.charAt(i - 1) - 'a'] > 0) {
                    dp[i][j] = (dp[i][j] + (int) ((long) dp[i - 1][j - 1] * count[j - 1][target.charAt(i - 1) - 'a'] % mod)) % mod;
                }
            }
        }
        return dp[target.length()][words[0].length()];
    }
}