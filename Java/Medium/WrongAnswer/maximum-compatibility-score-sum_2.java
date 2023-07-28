class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        
        int n = students.length;
        int m = students[0].length;
        int[][] score = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (students[i][k] == mentors[j][k]) {
                        score[i][j]++;
                    }
                }
            }
        }
        int[] dp = new int[1 << n];
        for (int i = 0; i < n; i++) {
            dp[1 << i] = score[i][0];
        }
        for (int i = 1; i < (1 << n); i++) {
            int[] bits = getBits(i);
            int x = bits[bits.length - 1];
            for (int j = 0; j < bits.length - 1; j++) {
                int y = bits[j];
                dp[i] = Math.max(dp[i], dp[i ^ (1 << x)] + score[x][y]);
            }
        }
        return dp[(1 << n) - 1];
    }

    private int[] getBits(int x) {
        int[] bits = new int[Integer.bitCount(x)];
        int idx = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                bits[idx++] = Integer.numberOfTrailingZeros(x);
            }
            x >>= 1;
        }
        return bits;
    }
}