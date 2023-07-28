class Solution {
    public int numWays(String[] words, String target) {
        
        int[][] count = new int[target.length()][26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        int[][] dp = new int[target.length()][target.length()];
        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (i == 0) {
                    dp[i][i] += count[i][j];
                } else {
                    for (int k = 0; k < i; k++) {
                        dp[i][k] += dp[i - 1][k];
                    }
                    for (int k = 0; k < i; k++) {
                        dp[i][i] += dp[i - 1][k] * count[i][j];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < target.length(); i++) {
            ans += dp[target.length() - 1][i];
        }
        return ans;
    }
}