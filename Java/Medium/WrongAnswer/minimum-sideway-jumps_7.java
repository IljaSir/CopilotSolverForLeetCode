class Solution {
    public int minSideJumps(int[] obstacles) {
        
        int[] dp = new int[]{1, 0, 1};
        for (int i = 1; i < obstacles.length; i++) {
            int[] next = new int[3];
            Arrays.fill(next, Integer.MAX_VALUE);
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) continue;
                next[j] = dp[j];
                for (int k = 0; k < 3; k++) {
                    if (k == j || obstacles[i] == k + 1) continue;
                    next[j] = Math.min(next[j], dp[k] + 1);
                }
            }
            dp = next;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}