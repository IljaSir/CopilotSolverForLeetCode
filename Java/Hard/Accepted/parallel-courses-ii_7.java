class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] graph = new int[n];
        for (int[] relation: relations) {
            int prev = relation[0] - 1;
            int next = relation[1] - 1;
            graph[next] |= (1 << prev);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int state = 0; state < (1 << n); state++) {
            int canTake = 0;
            for (int i = 0; i < n; i++) {
                if (((state >> i) & 1) == 0 && (state & graph[i]) == graph[i]) {
                    canTake |= (1 << i);
                }
            }
            for (int take = canTake; take > 0; take = (take - 1) & canTake) {
                if (Integer.bitCount(take) <= k) {
                    dp[state | take] = Math.min(dp[state | take], dp[state] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}