class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int[] digits = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] dp = new int[4][10];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][startAt] = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int k = 0; k < 10; k++) {
                    int cost = dp[i][j] + Math.abs(j - k) * moveCost;
                    int next = (k + (j - k + 10) % 10) % 10;
                    dp[i + 1][next] = Math.min(dp[i + 1][next], cost + pushCost);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            int cost = dp[i][targetSeconds % 10];
            if (cost == Integer.MAX_VALUE) {
                continue;
            }
            cost += (targetSeconds / 10) * pushCost;
            ans = Math.min(ans, cost);
        }
        return ans;
    }
}
    }
}