class Solution {
    public int maximumGroups(int[] grades) {
        
        int[] count = new int[100001];
        for (int g : grades) {
            count[g]++;
        }
        int[] sum = new int[100001];
        int[] size = new int[100001];
        for (int i = 1; i < 100001; i++) {
            sum[i] = sum[i - 1] + i * count[i];
            size[i] = size[i - 1] + count[i];
        }
        int n = grades.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < 100001; i++) {
            for (int j = n; j >= size[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - size[i]] + sum[i] - sum[i - 1]);
            }
        }
        return dp[n];
    }
}