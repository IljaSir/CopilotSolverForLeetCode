class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        
        int[] prereqs = new int[n];
        for (int[] relation : relations) {
            prereqs[relation[1] - 1] |= 1 << (relation[0] - 1);
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int state = 0; state < 1 << n; state++) {
            int taken = 0;
            for (int i = 0; i < n; i++) {
                if ((state & 1 << i) == 0 && (prereqs[i] & state) == prereqs[i]) {
                    taken |= 1 << i;
                }
            }
            for (int subset = taken; subset > 0; subset = (subset - 1) & taken) {
                if (Integer.bitCount(subset) <= k) {
                    dp[state | subset] = Math.min(dp[state | subset], dp[state] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}