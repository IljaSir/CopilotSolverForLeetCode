class Solution {
    public int countVowelSubstrings(String word) {
        
        int n = word.length();
        int[][] dp = new int[n][5];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (word.charAt(i) == "aeiou".charAt(j)) {
                    if (i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1;
                        for (int k = 0; k < j; ++k) {
                            dp[i][j] += dp[i - 1][k];
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 5; ++j) {
            ans += dp[n - 1][j];
        }
        return ans;
    }
}