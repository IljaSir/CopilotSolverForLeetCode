class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        
        int size1 = cost.size();
        int size2 = cost.get(0).size();
        int[][] dp = new int[size1 + 1][1 << size2];
        for (int i = 0; i <= size1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= size1; i++) {
            for (int j = 0; j < (1 << size2); j++) {
                for (int k = 0; k < size2; k++) {
                    dp[i][j | (1 << k)] = Math.min(dp[i][j | (1 << k)], dp[i - 1][j] + cost.get(i - 1).get(k));
                }
            }
        }
        int ans = dp[size1][(1 << size2) - 1];
        for (int j = 0; j < (1 << size2); j++) {
            int sum = 0;
            for (int k = 0; k < size2; k++) {
                if (((j >> k) & 1) == 1) {
                    int min = Integer.MAX_VALUE;
                    for (int i = 0; i < size1; i++) {
                        min = Math.min(min, cost.get(i).get(k));
                    }
                    sum += min;
                }
            }
            ans = Math.min(ans, sum + dp[size1][j]);
        }
        return ans;
    }
}