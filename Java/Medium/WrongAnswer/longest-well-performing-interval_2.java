class Solution {
    public int longestWPI(int[] hours) {
        
        int n = hours.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i] + (hours[i] > 8 ? 1 : -1);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > 0) {
                result = i + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[j + 1] - dp[i] > 0) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}