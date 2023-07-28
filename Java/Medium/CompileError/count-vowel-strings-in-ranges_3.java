class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[][] dp = new int[words.length][5];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (isVowel(words[i].charAt(0)) ? 1 : 0);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            for (int j = 0; j < 5; j++) {
                if (query[0] == 0) {
                    ans[i] += dp[query[1]][j];
                } else {
                    ans[i] += dp[query[1]][j] - dp[query[0] - 1][j];
                }
            }
        }
        return ans;
    }
}