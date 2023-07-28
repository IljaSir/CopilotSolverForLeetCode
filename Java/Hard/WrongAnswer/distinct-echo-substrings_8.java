class Solution {
    public int distinctEchoSubstrings(String text) {
        
        int n = text.length();
        int[][] dp = new int[n][n];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] * 31 + (text.charAt(j) - 'a');
                }
                if (j - i + 1 > 0 && (j - i + 1) % 2 == 0) {
                    int len = (j - i + 1) / 2;
                    if (dp[i][i + len - 1] == dp[i + len][j]) {
                        set.add(text.substring(i, j + 1));
                    }
                }
            }
        }
        return set.size();
    }
}