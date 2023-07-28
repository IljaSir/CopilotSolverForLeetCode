class Solution {
    public int maximumDetonation(int[][] bombs) {
        
        int n = bombs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(bombs, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.sqrt(Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2)) <= bombs[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}