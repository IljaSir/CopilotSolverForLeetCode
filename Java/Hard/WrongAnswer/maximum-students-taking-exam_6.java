class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length, n = seats[0].length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int[] ndp = new int[1 << n];
            for (int j = 0; j < (1 << n); j++) {
                if (check(j, seats[i])) {
                    for (int k = 0; k < (1 << n); k++) {
                        if ((j & k) == 0) {
                            ndp[j] = Math.max(ndp[j], dp[k] + Integer.bitCount(j));
                        }
                    }
                }
            }
            dp = ndp;
        }
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    private boolean check(int state, char[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == '#' && ((state >> i) & 1) == 1) {
                return false;
            }
        }
        return true;
    }
}