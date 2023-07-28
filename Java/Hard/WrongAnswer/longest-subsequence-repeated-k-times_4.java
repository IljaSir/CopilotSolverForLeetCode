class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == s.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                sb.append(s.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        String ans = sb.reverse().toString();
        if (ans.length() * k > n) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int t = 0; t < k; ++t) {
            res.append(ans);
        }
        return res.toString();
    }
}