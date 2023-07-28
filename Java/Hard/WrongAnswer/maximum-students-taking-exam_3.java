class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        int[][] dp = new int[m][1 << n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(seats, 0, 0, dp);
    }
    private int dfs(char[][] seats, int i, int state, int[][] dp) {
        int m = seats.length;
        int n = seats[0].length;
        if (i == m) {
            return 0;
        }
        if (dp[i][state] != -1) {
            return dp[i][state];
        }
        int res = 0;
        for (int j = 0; j < (1 << n); j++) {
            if (isValid(seats, i, j)) {
                res = Math.max(res, Integer.bitCount(j) + dfs(seats, i + 1, j, dp));
            }
        }
        dp[i][state] = res;
        return res;
    }
    private boolean isValid(char[][] seats, int i, int state) {
        int n = seats[0].length;
        for (int j = 0; j < n; j++) {
            if (seats[i][j] == '#' && ((state >> j) & 1) == 1) {
                return false;
            }
            if (j > 0 && ((state >> j) & 1) == 1 && ((state >> (j - 1)) & 1) == 1) {
                return false;
            }
            if (j < n - 1 && ((state >> j) & 1) == 1 && ((state >> (j + 1)) & 1) == 1) {
                return false;
            }
        }
        return true;
    }
}