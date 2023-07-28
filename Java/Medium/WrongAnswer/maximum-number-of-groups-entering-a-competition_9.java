class Solution {
    public int maximumGroups(int[] grades) {
        
        int N = grades.length;
        int[] count = new int[100001];
        for (int grade : grades) {
            count[grade]++;
        }
        int[][] dp = new int[2][N + 1];
        for (int i = 1; i <= 100000; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i % 2][j] = dp[i % 2][j - 1];
                if (count[i] >= j) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - 1] + 1);
                }
                if (count[i] >= 2 * j) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j] + 1);
                }
            }
        }
        return dp[100000 % 2][N];
    }
}