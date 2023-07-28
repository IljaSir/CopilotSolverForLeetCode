class Solution {
    public int palindromePartition(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][1] = getMinCost(s.substring(0, i + 1));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int m = 0; m < i; m++) {
                    dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + getMinCost(s.substring(m + 1, i + 1)));
                }
            }
        }
        return dp[n - 1][k];
    }

    private int getMinCost(String s) {
        int n = s.length();
        int cost = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                cost++;
            }
        }
        return cost;
    }
}