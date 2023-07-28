class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int c = s.charAt(i) - 'a';
                for (int l = 0; l < 26; l++) {
                    int cost = c == l ? 0 : 1;
                    int nk = j + (c == l ? 0 : 1);
                    if (nk <= k) {
                        dp[i + 1][nk] = Math.min(dp[i + 1][nk], dp[i][j] + cost);
                    }
                }
                int l = 1;
                while (i + l < n && s.charAt(i + l) == s.charAt(i)) {
                    l++;
                    int nk = j + l - 1;
                    if (nk <= k) {
                        dp[i + l][nk] = Math.min(dp[i + l][nk], dp[i][j] + getCost(l));
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= k; j++) {
            ans = Math.min(ans, dp[n][j]);
        }
        return ans;
    }
    private int getCost(int l) {
        if (l <= 2) {
            return l;
        } else if (l <= 9) {
            return 3;
        } else if (l <= 99) {
            return 4;
        } else {
            return 5;
        }
    }
}