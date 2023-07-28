class Solution {
    public int findRotateSteps(String ring, String key) {
        
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m+1][n];
        for (int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (dp[i][j] < Integer.MAX_VALUE)
                    for (int k = 0; k < n; ++k)
                        if (ring.charAt(k) == key.charAt(i)) {
                            int diff = Math.abs(j - k);
                            int step = Math.min(diff, n - diff);
                            dp[i+1][k] = Math.min(dp[i+1][k], dp[i][j] + step);
                        }

        int res = Integer.MAX_VALUE;
        for (int x: dp[m])
            res = Math.min(res, x);
        return res + m;
    }
}