class Solution {
    public int countPalindromes(String s) {
        
        int MOD = 1000000007;
        int n = s.length();
        int[][] dp = new int[n][10];
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            dp[i][x]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 4; j < n; j++) {
                int x = s.charAt(i) - '0';
                int y = s.charAt(j) - '0';
                if (x == y) {
                    int count = 0;
                    for (int k = 0; k < 10; k++) {
                        count += dp[j - 1][k] - (i > 0 ? dp[i - 1][k] : 0);
                    }
                    ans = (ans + count) % MOD;
                }
            }
        }
        return ans;
    }
}