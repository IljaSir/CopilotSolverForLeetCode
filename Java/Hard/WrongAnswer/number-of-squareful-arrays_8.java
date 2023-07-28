class Solution {
    public int numSquarefulPerms(int[] nums) {
        
        int n = nums.length;
        int[] mask = new int[1<<n];
        int[][] dp = new int[1<<n][n];
        int[] square = new int[100];
        for (int i = 0; i < 100; i++) {
            square[i] = i * i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSquare(nums[i] + nums[j], square)) {
                    mask[1<<i | 1<<j] |= 1<<j;
                    mask[1<<i | 1<<j] |= 1<<i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            dp[1<<i][i] = 1;
        }
        for (int i = 1; i < 1<<n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i>>j) & 1) == 1) {
                    for (int k = 0; k < n; k++) {
                        if (j == k) {
                            continue;
                        }
                        if (((i>>k) & 1) == 1 && (mask[i] & (1<<k)) != 0) {
                            dp[i][j] += dp[i ^ (1<<j)][k];
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += dp[(1<<n) - 1][i];
        }
        return res;
    }
    private boolean isSquare(int x, int[] square) {
        int l = 0, r = square.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (square[m] == x) {
                return true;
            }
            if (square[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }
}