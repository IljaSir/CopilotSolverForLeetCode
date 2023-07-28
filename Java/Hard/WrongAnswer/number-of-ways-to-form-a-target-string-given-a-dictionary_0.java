class Solution {
    public int numWays(String[] words, String target) {
        
        int[][] count = new int[words[0].length()][26];
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        int[][] dp = new int[target.length()][words[0].length()];
        for (int i = 0; i < words[0].length(); i++) {
            if (target.charAt(0) == words[0].charAt(i)) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < target.length(); i++) {
            for (int j = i; j < words[0].length(); j++) {
                if (target.charAt(i) == words[0].charAt(j)) {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= 1000000007;
                    }
                }
            }
        }
        int result = 0;
        for (int i = target.length() - 1; i < words[0].length(); i++) {
            result += dp[target.length() - 1][i];
            result %= 1000000007;
        }
        return result;
    }
}