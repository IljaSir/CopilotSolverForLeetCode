class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        
        int n = nextVisit.length;
        long[] dp = new long[n];
        int mod = 1000000007;
        for (int i = 1; i < n; i++) {
            dp[i] = (dp[i - 1] * 2 - dp[nextVisit[i - 1]] + 2 + mod) % mod;
        }
        return (int) dp[n - 1];
    }
}