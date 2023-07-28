class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        for (int l 3; l <n; l++) 
            for (int i = 0; i <= n - li++) {
                int j = i + l 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}