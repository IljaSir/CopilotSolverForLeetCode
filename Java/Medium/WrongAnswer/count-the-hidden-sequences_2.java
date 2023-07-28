class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        long[] dp = new long[differences.length + 1];
        int mod = 1000000007;
        dp[0] = 1;
        long sum = 0;
        for (int i = 0; i < differences.length; i++) {
            sum += differences[i];
            dp[i + 1] = (sum - upper) * (sum - lower + 1) / 2;
            dp[i + 1] = (dp[i + 1] + dp[i]) % mod;
        }
        return (int) (dp[differences.length] % mod);
    }
}