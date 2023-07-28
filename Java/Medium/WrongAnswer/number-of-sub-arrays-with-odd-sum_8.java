class Solution {
    public int numOfSubarrays(int[] arr) {
        
        long[] dp = new long[2];
        dp[0] = 1;
        long sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            dp[(int)sum % 2]++;
        }
        return (int) ((dp[0] * (dp[0] - 1) / 2 + dp[1] * (dp[1] - 1) / 2) % mod);
    }
}