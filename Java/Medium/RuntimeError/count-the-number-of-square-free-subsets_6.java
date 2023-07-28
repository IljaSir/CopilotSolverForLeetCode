class Solution {
    public int squareFreeSubsets(int[] nums) {
        
        int MOD = 1000000007;
        int n = nums.length;
        int[] count = new int[31];
        for (int num: nums) {
            count[num]++;
        }
        int[] dp = new int[1 << 31];
        dp[0] = 1;
        for (int i = 1; i < (1 << 31); ++i) {
            int j = Integer.numberOfTrailingZeros(i);
            dp[i] = (dp[i - (1 << j)] * (count[j] + 1)) % MOD;
        }
        int ans = 0;
        for (int i = 1; i < (1 << 31); ++i) {
            int cnt = Integer.bitCount(i);
            if (cnt % 2 == 0) {
                ans = (ans - dp[i] + MOD) % MOD;
            } else {
                ans = (ans + dp[i]) % MOD;
            }
        }
        return ans;
    }
}