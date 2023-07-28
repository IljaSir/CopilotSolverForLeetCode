class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        
        int n = nextVisit.length;
        int mod = 1000000007;
        long[] dp = new long[n];
        for (int i = 1; i < n; i++) {
            dp[i] = (dp[i - 1] + 2 + n - 1 + mod - nextVisit[i - 1]) % mod;
        }
        long res = 0;
        for (int i = 1; i < n; i++) {
            res = (res + dp[i]) % mod;
        }
        return (int)res;
    }
}