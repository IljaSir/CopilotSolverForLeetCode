class Solution {
    public int numberWays(List<List<Integer>> hats) {
        
        int n = hats.size();
        int m = 40;
        int mod = (int)1e9 + 7;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[] hatToPeople = new int[41];
        for (int i = 0; i < n; i++) {
            for (int hat : hats.get(i)) {
                hatToPeople[hat] |= (1 << i);
            }
        }
        return dfs(1, hatToPeople, 0, dp, mod);
    }
    
    private int dfs(int hat, int[] hatToPeople, int mask, int[][] dp, int mod) {
        if (hat > 40) {
            return mask == (1 << dp.length) - 1 ? 1 : 0;
        }
        if (dp[Integer.bitCount(mask)][mask] != -1) {
            return dp[Integer.bitCount(mask)][mask];
        }
        int res = dfs(hat + 1, hatToPeople, mask, dp, mod);
        res = (res + dfs(hat + 1, hatToPeople, mask | hatToPeople[hat], dp, mod)) % mod;
        return dp[Integer.bitCount(mask)][mask] = res;
    }
}