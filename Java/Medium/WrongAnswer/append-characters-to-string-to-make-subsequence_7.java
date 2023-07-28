class Solution {
    public int appendCharacters(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int i = n - 1;
        int j = m - 1;
        int count = 0;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                i--;
                count++;
            }
        }

        return count;
    }
}