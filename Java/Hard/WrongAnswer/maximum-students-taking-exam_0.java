class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        int[][] dp = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 1 << n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(seats, 0, 0, dp);
    }
    
    private int dfs(char[][] seats, int i, int j, int[][] dp) {
        if (i == seats.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = 0;
        int m = seats.length;
        int n = seats[0].length;
        for (int k = 0; k < 1 << n; k++) {
            boolean valid = true;
            for (int l = 0; l < n; l++) {
                if (((j >> l) & 1) == 1 && ((k >> l) & 1) == 1) {
                    valid = false;
                    break;
                }
                if (l > 0 && ((j >> (l - 1)) & 1) == 1 && ((k >> l) & 1) == 1) {
                    valid = false;
                    break;
                }
                if (l < n - 1 && ((j >> (l + 1)) & 1) == 1 && ((k >> l) & 1) == 1) {
                    valid = false;
                    break;
                }
                if (seats[i][l] == '#' && ((k >> l) & 1) == 1) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                max = Math.max(max, Integer.bitCount(k) + dfs(seats, i + 1, k, dp));
            }
        }
        dp[i][j] = max;
        return max;
    }
}