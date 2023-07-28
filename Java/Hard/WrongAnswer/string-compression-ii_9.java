class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[][] dp = new int[len + 1][k + 1];
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int count = 0;
                for (int m = i; m < len; m++) {
                    if (s.charAt(m) != s.charAt(i)) {
                        break;
                    }
                    count++;
                    if (count + j <= k) {
                        dp[m + 1][j + count] = Math.min(dp[m + 1][j + count], dp[i][j] + getLength(count));
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, dp[len][i]);
        }
        return res;
    }
    private int getLength(int count) {
        if (count == 1) {
            return 1;
        }
        if (count < 10) {
            return 2;
        }
        if (count < 100) {
            return 3;
        }
        return 4;
    }
}