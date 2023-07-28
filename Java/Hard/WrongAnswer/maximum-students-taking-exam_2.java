class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        int[][] dp = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(seats, 0, 0, dp);
    }
    
    private int dfs(char[][] seats, int row, int prev, int[][] dp) {
        if (row == seats.length) {
            return 0;
        }
        if (dp[row][prev] != -1) {
            return dp[row][prev];
        }
        int max = 0;
        for (int mask = 0; mask < (1 << seats[0].length); mask++) {
            if (isValid(mask, prev, seats[row])) {
                max = Math.max(max, Integer.bitCount(mask) + dfs(seats, row + 1, mask, dp));
            }
        }
        dp[row][prev] = max;
        return max;
    }
    
    private boolean isValid(int mask, int prev, char[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '#') {
                if (((mask >> i) & 1) == 1) {
                    return false;
                }
            } else {
                if (i > 0) {
                    if (((mask >> (i - 1)) & 1) == 1 && ((prev >> (i - 1)) & 1) == 1) {
                        return false;
                    }
                }
                if (((mask >> i) & 1) == 1 && ((prev >> i) & 1) == 1) {
                    return false;
                }
                if (i < row.length - 1) {
                    if (((mask >> (i + 1)) & 1) == 1 && ((prev >> (i + 1)) & 1) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}