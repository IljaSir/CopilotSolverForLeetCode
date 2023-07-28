class Solution {
    public int fillCups(int[] amount) {
        
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, amount[i]);
        }
        int[] dp = new int[max + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= max; j++) {
                if (j <= amount[i]) {
                    dp[j] += 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[j - amount[i]] + 1);
                }
            }
        }
        return dp[max];
    }
}
    }
}