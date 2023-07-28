class Solution {
    public int maxJump(int[] stones) {
        
        int n = stones.length;
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, stones[i] - stones[i - 1]);
        }
        return max;
    }

    public int minCost(int[] stones) {
        int n = stones.length;
        int maxJump = maxJump(stones);
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int k = i + 1; k < n; k++) {
                    int jump = stones[k] - stones[i];
                    if (jump < j - 1) {
                        continue;
                    }
                    if (jump > j + 1) {
                        break;
                    }
                    dp[k][jump] = Math.min(dp[k][jump], dp[i][j] + (jump == j - 1 ? 0 : 1));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}