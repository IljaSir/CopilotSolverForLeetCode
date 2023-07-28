class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        
        int n = s.length();
        String[][] dp = new String[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = "";
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == s.charAt(j-1) && i != j) {
                    String candidate = s.charAt(i-1) + dp[i-1][j-1];
                    if (candidate.length() > dp[i][j].length() || (candidate.length() == dp[i][j].length() && candidate.compareTo(dp[i][j]) > 0)) {
                        dp[i][j] = candidate;
                    }
                }
            }
        }
        String res = "";
        for (int i = 1; i <= n; i++) {
            String candidate = dp[i][i];
            if (candidate.length() > 0) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (s.startsWith(candidate, j)) {
                        count++;
                        j += candidate.length() - 1;
                    }
                }
                if (count == k && (candidate.length() > res.length() || (candidate.length() == res.length() && candidate.compareTo(res) > 0))) {
                    res = candidate;
                }
            }
        }
        return res;
    }
}