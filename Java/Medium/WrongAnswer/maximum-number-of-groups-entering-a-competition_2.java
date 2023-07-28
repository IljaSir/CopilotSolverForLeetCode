class Solution {
    public int maximumGroups(int[] grades) {
        
        int[] count = new int[100001];
        for (int i = 0; i < grades.length; i++) {
            count[grades[i]]++;
        }
        int[] dp = new int[100001];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i <= 100000; i++) {
            dp[i] = dp[i - 1];
            if (count[i] > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1] + count[i]);
                if (i > 1 && count[i - 1] > 0) {
                    dp[i] = Math.max(dp[i], dp[i - 2] + count[i] + count[i - 1]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}