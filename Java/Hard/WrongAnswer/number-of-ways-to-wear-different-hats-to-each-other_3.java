class Solution {
    public int numberWays(List<List<Integer>> hats) {
        
        int n = hats.size();
        Map<Integer, List<Integer>> hatsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int hat : hats.get(i)) {
                hatsMap.putIfAbsent(hat, new ArrayList<>());
                hatsMap.get(hat).add(i);
            }
        }
        int mod = 1000000007;
        int[][] dp = new int[41][1024];
        dp[0][0] = 1;
        for (int i = 1; i <= 40; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                dp[i][mask] = dp[i - 1][mask];
                if (hatsMap.containsKey(i)) {
                    for (int j : hatsMap.get(i)) {
                        if (((mask >> j) & 1) == 0) {
                            dp[i][mask] = (dp[i][mask] + dp[i - 1][mask | (1 << j)]) % mod;
                        }
                    }
                }
            }
        }
        return dp[40][(1 << n) - 1];
    }
}