class Solution {
    public int largestCombination(int[] candidates) {
        
        int n = candidates.length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            int and = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    and &= candidates[j];
                }
            }
            dp[i] = and;
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (dp[i] > 0) {
                ans = Math.max(ans, Integer.bitCount(i));
            }
        }
        return ans;
    }
}