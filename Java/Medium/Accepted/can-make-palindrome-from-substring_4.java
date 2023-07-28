class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        int[][] dp = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][s.charAt(i - 1) - 'a']++;
        }
        for (int[] query : queries) {
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                if ((dp[query[1] + 1][i] - dp[query[0]][i]) % 2 == 1) {
                    odd++;
                }
            }
            result.add(odd / 2 <= query[2]);
        }
        return result;
    }
}