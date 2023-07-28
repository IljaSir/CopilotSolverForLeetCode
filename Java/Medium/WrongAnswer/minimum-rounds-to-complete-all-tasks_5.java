class Solution {
    public int minimumRounds(int[] tasks) {
        
        int n = tasks.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                dp[i][j] = tasks[j];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }
        int[] f = new int[n];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int max = dp[i][j];
                int r = (max + 1) / 2;
                int l = (max + 2) / 3;
                f[j] = Math.min(f[j], f[i] + r + l);
            }
        }
        return f[n - 1];
    }
}