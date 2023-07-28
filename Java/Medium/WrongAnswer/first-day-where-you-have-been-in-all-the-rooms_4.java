class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        
        int n = nextVisit.length;
        int mod = 1_000_000_007;
        long[] dp = new long[n];
        for (int i = 1; i < n; i++) {
            dp[i] = 2 * dp[i - 1] + i - nextVisit[i] + 2;
            dp[i] %= mod;
        }
        return (int) dp[n - 1];
    }
}