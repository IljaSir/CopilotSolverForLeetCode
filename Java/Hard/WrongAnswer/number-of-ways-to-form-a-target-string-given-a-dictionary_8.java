class Solution {
    public int numWays(String[] words, String target) {
        
        int mod = 1000000007;
        int[][] dp = new int[target.length()][26];
        for (int i = 0; i < words[0].length(); i++) {
            for (String word : words) {
                int idx = word.charAt(i) - 'a';
                dp[target.length() - 1][idx] = (dp[target.length() - 1][idx] + 1) % mod;
            }
        }
        for (int i = target.length() - 2; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                for (String word : words) {
                    if (word.charAt(i) - 'a' == j) {
                        dp[i][j] = (dp[i][j] + dp[i + 1][target.charAt(i + 1) - 'a']) % mod;
                    }
                }
            }
        }
        return dp[0][target.charAt(0) - 'a'];
    }
}