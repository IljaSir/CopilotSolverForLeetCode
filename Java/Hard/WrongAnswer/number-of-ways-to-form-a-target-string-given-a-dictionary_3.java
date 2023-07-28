class Solution {
    public int numWays(String[] words, String target) {
        
        int n = words[0].length();
        int m = target.length();
        int[][] count = new int[n][26];
        for (String word : words) {
            for (int i = 0; i < n; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        int[][] dp = new int[m + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            int c = target.charAt(i) - 'a';
            for (int j = i; j < n; j++) {
                if (count[j][c] == 0) {
                    continue;
                }
                for (int k = 0; k <= j; k++) {
                    dp[i + 1][j] = (dp[i + 1][j] + (int) ((long) dp[i][k] * count[j][c] % 1000000007)) % 1000000007;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dp[m][i]) % 1000000007;
        }
        return ans;
    }
}