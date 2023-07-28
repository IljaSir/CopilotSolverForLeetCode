class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length, n = seats[0].length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int[] ndp = new int[1 << n];
            for (int j = 0; j < (1 << n); j++) {
                if (isValid(seats, i, j, n)) {
                    for (int k = 0; k < (1 << n); k++) {
                        if ((k & j) == 0) {
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
    private boolean isValid(char[][] seats, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if ((j & (1 << k)) > 0) {
                if (seats[i][k] == '#') {
                    return false;
                }
                if (k > 0 && (j & (1 << (k - 1))) > 0) {
                    return false;
                }
                if (k < n - 1 && (j & (1 << (k + 1))) > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}