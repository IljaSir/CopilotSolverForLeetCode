class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int n = words.length;
        int m = queries.length;
        int[] ans = new int[m];
        int[][] dp = new int[n][5];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < 5; j++) {
                dp[i][j] = dp[i][j - 1];
                if (words[i].charAt(0) == "aeiou".charAt(j)) {
                    dp[i][j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int l = query[0];
            int r = query[1];
            int cnt = 0;
            for (int j = l; j <= r; j++) {
                cnt += dp[j][4];
            }
            ans[i] = cnt;
        }
        return ans;
    }
}