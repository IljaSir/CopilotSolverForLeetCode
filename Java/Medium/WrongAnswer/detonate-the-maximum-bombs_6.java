class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int[] dp = new int[n];
        Arrays.sort(bombs, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int dist = (bombs[i][0] - bombs[j][0]) * (bombs[i][0] - bombs[j][0]) + (bombs[i][1] - bombs[j][1]) * (bombs[i][1] - bombs[j][1]);
                if (dist <= bombs[i][2] * bombs[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}