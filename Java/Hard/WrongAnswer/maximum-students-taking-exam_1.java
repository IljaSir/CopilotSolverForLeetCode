class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        int[][] dp = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 1 << n; j++) {
                if (check(i, j, seats)) {
                    dp[i][j] = count(j);
                    if (i > 0) {
                        for (int k = 0; k < 1 << n; k++) {
                            if (check(i - 1, k, seats) && (k & j) == 0) {
                                dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + count(j));
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            ans = Math.max(ans, dp[m - 1][i]);
        }
        return ans;
    }
    
    private boolean check(int i, int j, char[][] seats) {
        for (int k = 0; k < seats[0].length; k++) {
            if ((j & 1) == 1 && seats[i][k] == '#') {
                return false;
            }
            j >>= 1;
        }
        return true;
    }
    
    private int count(int j) {
        int ans = 0;
        while (j > 0) {
            ans += j & 1;
            j >>= 1;
        }
        return ans;
    }
}