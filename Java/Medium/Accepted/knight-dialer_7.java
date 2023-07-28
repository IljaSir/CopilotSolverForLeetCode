class Solution {
    public int knightDialer(int n) {
        
        int[][] dirs = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
        int[][] dp = new int[4][3];
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i == 3 && j != 1) continue;
                dp[i][j] = 1;
            }
        }
        int mod = 1000000007;
        for (int i = 1; i < n; ++i) {
            int[][] dp2 = new int[4][3];
            for (int r = 0; r < 4; ++r) {
                for (int c = 0; c < 3; ++c) {
                    if (r == 3 && c != 1) continue;
                    for (int[] dir : dirs) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr >= 0 && nr < 4 && nc >= 0 && nc < 3 && !(nr == 3 && nc != 1)) {
                            dp2[r][c] = (dp2[r][c] + dp[nr][nc]) % mod;
                        }
                    }
                }
            }
            dp = dp2;
        }
        int ans = 0;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (i == 3 && j != 1) continue;
                ans = (ans + dp[i][j]) % mod;
            }
        }
        return ans;
    }
}