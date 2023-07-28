class Solution {
    public int numberWays(List<List<Integer>> hats) {
        
        int n = hats.size();
        int m = 40;
        int mod = 1000000007;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(hats, 0, 0, dp) % mod;
    }
    private int dfs(List<List<Integer>> hats, int i, int mask, int[][] dp) {
        if (i == 40) {
            return mask == (1 << hats.size()) - 1 ? 1 : 0;
        }
        if (dp[i][mask] != -1) {
            return dp[i][mask];
        }
        int res = dfs(hats, i + 1, mask, dp);
        for (int j = 0; j < hats.size(); j++) {
            if ((mask & (1 << j)) != 0) {
                continue;
            }
            if (hats.get(j).contains(i + 1)) {
                res += dfs(hats, i + 1, mask | (1 << j), dp);
            }
        }
        dp[i][mask] = res;
        return res;
    }
}