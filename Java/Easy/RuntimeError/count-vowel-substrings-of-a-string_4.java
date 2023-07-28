class Solution {
    public int countVowelSubstrings(String word) {
        
        int n = word.length();
        int[][] dp = new int[n][5];
        for (int i = 0; i < n; i++) {
            int j = word.charAt(i) - 'a';
            dp[i][j] = 1;
            for (int k = 0; k < j; k++) {
                dp[i][j] += dp[i - 1][k];
            }
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += dp[n - 1][i];
        }
        return ans;
    }
}