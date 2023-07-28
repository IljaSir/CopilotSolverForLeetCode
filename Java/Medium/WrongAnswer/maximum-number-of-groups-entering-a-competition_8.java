class Solution {
    public int maximumGroups(int[] grades) {
        
        int n = grades.length;
        int[] counts = new int[100001];
        for (int grade : grades) {
            counts[grade]++;
        }
        int[] prefix = new int[100001];
        for (int i = 1; i < 100001; i++) {
            prefix[i] = prefix[i - 1] + counts[i];
        }
        int[] sum = new int[100001];
        for (int i = 1; i < 100001; i++) {
            sum[i] = sum[i - 1] + i * counts[i];
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < 100001; i++) {
            for (int j = counts[i]; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - counts[i]] + i * (prefix[j] - prefix[j - counts[i]]) - (sum[j] - sum[j - counts[i]]));
            }
        }
        return dp[n];
    }
}