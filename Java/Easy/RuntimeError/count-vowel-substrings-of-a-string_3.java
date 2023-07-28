class Solution {
    public int countVowelSubstrings(String word) {
        
        int n = word.length();
        int[][] dp = new int[n][5];
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            dp[i][idx] = 1;
            for (int j = 0; j < idx; j++) {
                dp[i][idx] += dp[i - 1][j];
            }
        }
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result += dp[n - 1][i];
        }
        return result;
    }
}