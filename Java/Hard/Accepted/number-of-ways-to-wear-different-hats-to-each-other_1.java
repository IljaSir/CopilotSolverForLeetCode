class Solution {
    public int numberWays(List<List<Integer>> hats) {
        
        int n = hats.size();
        int mod = (int)1e9 + 7;
        int[] dp = new int[1 << n];
        dp[0] = 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int hat : hats.get(i)) {
                map.computeIfAbsent(hat, x -> new ArrayList<>()).add(i);
            }
        }
        for (int hat = 1; hat <= 40; hat++) {
            int[] dp2 = dp.clone();
            for (int mask = 0; mask < (1 << n); mask++) {
                for (int i : map.getOrDefault(hat, new ArrayList<>())) {
                    if (((mask >> i) & 1) == 0) {
                        dp2[mask | (1 << i)] = (dp2[mask | (1 << i)] + dp[mask]) % mod;
                    }
                }
            }
            dp = dp2;
        }
        return dp[(1 << n) - 1];
    }
}