class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        
        int n = nextVisit.length;
        long[] dp = new long[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2 + 2 * n) % 1000000007;
        }
        return (int) dp[n - 1];
    }
}