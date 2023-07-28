class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        
        Arrays.sort(restrictions, (a, b) -> {
            return a[0] - b[0];
        });
        
        int len = restrictions.length;
        int[][] dp = new int[len][2];
        dp[0][0] = restrictions[0][1];
        dp[0][1] = restrictions[0][1];
        for (int i = 1; i < len; i++) {
            int x = restrictions[i][0];
            int y = restrictions[i][1];
            dp[i][0] = Math.min(y, Math.max(dp[i - 1][0], dp[i - 1][1] + (x - restrictions[i - 1][0])));
            dp[i][1] = Math.min(y, Math.max(dp[i - 1][1], dp[i - 1][0] + (x - restrictions[i - 1][0])));
        }
        
        int ans = dp[len - 1][0];
        for (int i = len - 2; i >= 0; i--) {
            int x = restrictions[i][0];
            int y = restrictions[i][1];
            int h = Math.min(y, Math.max(dp[i + 1][0], dp[i + 1][1] + (restrictions[i + 1][0] - x)));
            ans = Math.max(ans, h);
        }
        
        int[] last = restrictions[len - 1];
        ans = Math.max(ans, n - last[0] + last[1]);
        return ans;
    }
}