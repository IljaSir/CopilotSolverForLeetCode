class Solution {
    public int numberWays(List<List<Integer>> hats) {
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < hats.size(); i++) {
            for (int hat : hats.get(i)) {
                List<Integer> list = map.getOrDefault(hat, new ArrayList<>());
                list.add(i);
                map.put(hat, list);
            }
        }
        int mod = (int)1e9 + 7;
        int[][] dp = new int[41][1 << hats.size()];
        dp[0][0] = 1;
        for (int i = 1; i <= 40; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (map.containsKey(i)) {
                    for (int person : map.get(i)) {
                        if ((j & (1 << person)) != 0) {
                            dp[i][j] = (dp[i][j] + dp[i - 1][j - (1 << person)]) % mod;
                        }
                    }
                }
            }
        }
        return dp[40][dp[0].length - 1];
    }
}