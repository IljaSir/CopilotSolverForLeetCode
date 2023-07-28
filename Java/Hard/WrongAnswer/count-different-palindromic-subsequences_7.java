class Solution {
    public int countPalindromicSubsequences(String s) {
        
        int N = s.length();
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; ++i)
            dp[i][i] = 1;

        for (int i = 0; i < N-1; ++i)
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 3;
            } else {
                dp[i][i+1] = 2;
            }

        for (int len = 3; len <= N; ++len)
            for (int i = 0; i+len-1 < N; ++i) {
                int j = i+len-1;
                if (s.charAt(i) == s.charAt(j)) {
                    int low = i+1, high = j-1;
                    while (low <= high && s.charAt(low) != s.charAt(i))
                        low++;
                    while (low <= high && s.charAt(high) != s.charAt(i))
                        high--;

                    if (low > high)
                        dp[i][j] = dp[i+1][j-1]*2 + 2;
                    else if (low == high)
                        dp[i][j] = dp[i+1][j-1]*2 + 1;
                    else
                        dp[i][j] = dp[i+1][j-1]*2 - dp[low+1][high-1];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                }
                dp[i][j] = (dp[i][j] + 1000000007) % 1000000007;
            }

        return dp[0][N-1];
    }
}