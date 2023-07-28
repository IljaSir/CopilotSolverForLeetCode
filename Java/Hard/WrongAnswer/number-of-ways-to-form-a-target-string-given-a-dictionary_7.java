class Solution {
    public int numWays(String[] words, String target) {
        
        int mod = 1000000007;
        int n = words[0].length();
        int m = target.length();
        int[][] f = new int[m][26];
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            for (String word : words) {
                count[word.charAt(i) - 'a']++;
            }
            for (int j = 0; j < m; j++) {
                f[j][target.charAt(j) - 'a'] += count[target.charAt(j) - 'a'];
            }
        }
        long[] dp = new long[m];
        for (int i = 0; i < 26; i++) {
            dp[0] += f[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i] = (dp[i] + dp[i - 1] * f[i][j]) % mod;
            }
        }
        return (int) dp[m - 1];
    }
}