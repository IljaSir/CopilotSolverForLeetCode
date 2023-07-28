class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int mod = 1000000007;
        int[][] dp = new int[locations.length][fuel + 1];
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(locations, start, finish, fuel, dp, mod);
    }

    private int dfs(int[] locations, int start, int finish, int fuel, int[][] dp, int mod) {
        if (fuel < 0) {
            return 0;
        }
        if (dp[start][fuel] != -1) {
            return dp[start][fuel];
        }
        if (start == finish) {
            dp[start][fuel] = 1;
        } else {
            dp[start][fuel] = 0;
        }
        for (int i = 0; i < locations.length; i++) {
            if (i == start) {
                continue;
            }
            dp[start][fuel] = (dp[start][fuel] + dfs(locations, i, finish, fuel - Math.abs(locations[i] - locations[start]), dp, mod)) % mod;
        }
        return dp[start][fuel];
    }
}