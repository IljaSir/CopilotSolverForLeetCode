class Solution {
    public int largestCombination(int[] candidates) {
        
        Arrays.sort(candidates);
        int n = candidates.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && candidates[i] == candidates[j]) {
                j--;
            }
            if (j < 0) {
                dp[i] = 1;
            } else {
                dp[i] = dp[j] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}