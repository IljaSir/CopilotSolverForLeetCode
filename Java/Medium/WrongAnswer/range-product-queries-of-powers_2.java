class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        // powers[i] = 2^i
        int[] powers = new int[31];
        powers[0] = 1;
        for (int i = 1; i < 31; i++) {
            powers[i] = powers[i - 1] << 1;
        }
        // dp[i] = powers[0] * powers[1] * ... * powers[i]
        int[] dp = new int[31];
        dp[0] = 1;
        for (int i = 1; i < 31; i++) {
            dp[i] = dp[i - 1] * powers[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = dp[right] / dp[left];
        }
        return ans;
    }
}