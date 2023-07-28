class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j >= i) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + 1;
                int cnt = 0;
                for (int p = i - 1; p >= 0; p--) {
                    if (s.charAt(p) != s.charAt(i - 1)) {
                        break;
                    }
                    cnt++;
                    if (j + cnt >= i) {
                        break;
                    }
                    int len = getLength(cnt);
                    dp[i][j] = Math.min(dp[i][j], dp[p][j + cnt] + len);
                }
            }
        }
        return dp[n][k];
    }

    public int getLength(int cnt) {
        if (cnt == 1) {
            return 1;
        }
        if (cnt < 10) {
            return 2;
        }
        if (cnt < 100) {
            return 3;
        }
        return 4;
    }
}