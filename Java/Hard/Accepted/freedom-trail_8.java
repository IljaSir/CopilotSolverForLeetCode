class Solution {
    public int findRotateSteps(String ring, String key) {
        
        int N = ring.length();
        int M = key.length();
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < N; i++) {
            if (ring.charAt(i) == key.charAt(0)) {
                dp[0][i] = Math.min(i, N - i) + 1;
            }
        }
        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (ring.charAt(j) != key.charAt(i)) {
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    if (dp[i - 1][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int diff = Math.abs(j - k);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(diff, N - diff) + 1);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int x : dp[M - 1]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }
}