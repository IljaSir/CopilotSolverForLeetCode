class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        
        int n = s.length();
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(0, k - 1, s, minLength, dp);
    }
    private int dfs(int start, int k, String s, int minLength, int[][] dp) {
        if (start == s.length() && k == 0) {
            return 1;
        }
        if (k < 0 || start >= s.length()) {
            return 0;
        }
        if (dp[start][k] != -1) {
            return dp[start][k];
        }
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            if (isPrime(s.charAt(start)) && !isPrime(s.charAt(i))) {
                if (i - start + 1 >= minLength) {
                    res += dfs(i + 1, k - 1, s, minLength, dp);
                    res %= 1000000007;
                }
            }
        }
        dp[start][k] = res;
        return res;
    }
}