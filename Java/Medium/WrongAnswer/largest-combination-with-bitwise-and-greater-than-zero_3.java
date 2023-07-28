class Solution {
    public int largestCombination(int[] candidates) {
        
        Arrays.sort(candidates);
        int n = candidates.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if ((candidates[i] & candidates[j]) > 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}