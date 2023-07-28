class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int same = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    same++;
                }
                for (int l = 0; l <= k; l++) {
                    if (dp[i][l] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int cur = dp[i][l];
                    if (l + j - i - same >= k) {
                        continue;
                    }
                    if (j - i + 1 == same) {
                        dp[j+1][l + j - i - same] = Math.min(dp[j+1][l + j - i - same], cur + 1);
                    } else if (same < 10) {
                        dp[j+1][l + j - i - same] = Math.min(dp[j+1][l + j - i - same], cur + 2);
                    } else if (same < 100) {
                        dp[j+1][l + j - i - same] = Math.min(dp[j+1][l + j - i - same], cur + 3);
                    } else {
                        dp[j+1][l + j - i - same] = Math.min(dp[j+1][l + j - i - same], cur + 4);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        return ans;
    }
}