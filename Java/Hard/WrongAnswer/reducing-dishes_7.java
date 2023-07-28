class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += satisfaction[j];
                dp[i] = Math.max(dp[i], dp[j + 1] + sum);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}