class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        
        int mod = 1000000007;
        int n = nextVisit.length;
        long[] dp = new long[n];
        for (int i = 1; i < n; i++) {
            dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2 + mod) % mod;
        }
        return (int) dp[n - 1];
    }
}