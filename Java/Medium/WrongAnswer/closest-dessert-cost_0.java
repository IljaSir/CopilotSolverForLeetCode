class Solution {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        
        int[] toppingCosts2 = new int[toppingCosts.length * 2];
        for (int i = 0; i < toppingCosts.length; ++i) {
            toppingCosts2[i * 2] = toppingCosts[i];
            toppingCosts2[i * 2 + 1] = toppingCosts[i] * 2;
        }
        int[] dp = new int[20001];
        for (int i = 0; i < baseCosts.length; ++i) {
            dp[baseCosts[i]] = 1;
        }
        for (int i = 0; i < toppingCosts2.length; ++i) {
            for (int j = 20000; j >= toppingCosts2[i]; --j) {
                if (dp[j - toppingCosts2[i]] == 1) {
                    dp[j] = 1;
                }
            }
        }
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= 20000; ++i) {
            if (dp[i] == 1) {
                if (Math.abs(i - target) < diff) {
                    ans = i;
                    diff = Math.abs(i - target);
                } else if (Math.abs(i - target) == diff) {
                    ans = Math.min(ans, i);
                }
            }
        }
        return ans;
    }
}