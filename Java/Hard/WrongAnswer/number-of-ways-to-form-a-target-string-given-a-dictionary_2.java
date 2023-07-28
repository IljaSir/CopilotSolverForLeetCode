class Solution {
    public int numWays(String[] words, String target) {
        
        int[][] count = new int[words[0].length()][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                count[j][words[i].charAt(j) - 'a']++;
            }
        }
        int mod = 1000000007;
        int[] dp = new int[target.length()];
        for (int i = 0; i < target.length(); i++) {
            int c = target.charAt(i) - 'a';
            int sum = 0;
            for (int j = 0; j < words[0].length(); j++) {
                if (count[j][c] == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i] += count[j][c];
                } else {
                    dp[i] += dp[i - 1] * count[j][c];
                }
                dp[i] %= mod;
            }
        }
        return dp[target.length() - 1];
    }
}