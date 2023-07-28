class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int[] next = new int[1 << n];
            for (int j = 0; j < (1 << n); j++) {
                if (valid(j, seats, i, n)) {
                    for (int k = 0; k < (1 << n); k++) {
                        if ((j & k) == 0) {
                            next[j] = Math.max(next[j], dp[k] + Integer.bitCount(j));
                        }
                    }
                }
            }
            dp = next;
        }
        return dp[0];
    }
    
    private boolean valid(int state, char[][] seats, int row, int n) {
        for (int i = 0; i < n; i++) {
            if (seats[row][i] == '#' && ((state >> i) & 1) == 1) {
                return false;
            }
            if (i > 0 && seats[row][i - 1] == '.' && seats[row][i] == '.' && ((state >> i) & 1) == 1 && ((state >> (i - 1)) & 1) == 1) {
                return false;
            }
        }
        return true;
    }
}