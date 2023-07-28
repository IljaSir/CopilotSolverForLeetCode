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
                dp[i][j] = dp[i - 1][j] + 1;
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
                int cnt = 1;
                for (int l = i - 1; l >= 0 && j + l >= i - 1; l--) {
                    if (s.charAt(l) == s.charAt(i - 1)) {
                        cnt++;
                    } else {
                        break;
                    }
                    if (cnt > 2) {
                        dp[i][j] = Math.min(dp[i][j], dp[l][j + l - i + 1] + getLength(cnt));
                    }
                }
            }
        }
        return dp[n][k];
    }
    public int getLength(int cnt) {
        if (cnt <= 2) {
            return cnt;
        } else if (cnt <= 9) {
            return 2;
        } else if (cnt <= 99) {
            return 3;
        } else {
            return 4;
        }
    }
}