class Solution {
    public int kSimilarity(String s1, String s2) {
        
        int N = s1.length();
        int[][] dp = new int[N][N];
        for (int[] row: dp)
            Arrays.fill(row, N);
        for (int i = 0; i < N; ++i) {
            if (s1.charAt(i) == s2.charAt(i)) {
                dp[i][i] = 0;
                continue;
            }
            for (int j = i+1; j < N; ++j) {
                if (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)) {
                    dp[i][j] = dp[j][i] = 1;
                }
            }
        }

        for (int k = 2; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = i+1; j < N; ++j) {
                    if (dp[i][j] > k) continue;
                    for (int m = i+1; m < N; ++m) {
                        if (s1.charAt(m) == s2.charAt(j)) {
                            dp[i][j] = Math.min(dp[i][j], dp[m][j] + (m > i+1 ? 1 : 0));
                        }
                    }
                }
            }
        }

        return dp[0][N-1];
    }
}