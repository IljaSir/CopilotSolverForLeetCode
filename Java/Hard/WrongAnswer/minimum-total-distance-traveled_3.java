class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        long ans = 0;
        int n = robot.size();
        int m = factory.length;
        long[][] dp = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.abs(robot.get(i) - factory[j][0]);
            }
            Arrays.sort(dp[i]);
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += dp[j][i];
            }
            ans = Math.max(ans, sum + factory[i][1]);
        }
        return ans;
    }
}