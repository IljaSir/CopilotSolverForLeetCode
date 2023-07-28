class Solution {
    public int largestCombination(int[] candidates) {
        
        int n = candidates.length;
        Arrays.sort(candidates);
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        int[] prev = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((candidates[i] & candidates[j]) > 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}