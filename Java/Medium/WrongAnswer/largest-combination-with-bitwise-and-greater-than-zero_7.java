class Solution {
    public int largestCombination(int[] candidates) {
        
        Arrays.sort(candidates);
        int n = candidates.length;
        int[] dp = new int[n];
        int[] index = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = candidates[i];
            index[i] = i;
            result = Math.max(result, dp[i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((candidates[i] & candidates[j]) > 0 && index[j] + 1 == i) {
                    dp[i] = Math.max(dp[i], dp[j] + candidates[i]);
                    index[i] = i;
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}