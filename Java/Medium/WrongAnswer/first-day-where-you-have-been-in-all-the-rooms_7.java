class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        
        int mod = 1000000007;
        int[] dp = new int[nextVisit.length];
        for (int i = 1; i < nextVisit.length; i++) {
            dp[i] = (dp[i - 1] * 2 - dp[nextVisit[i - 1]] + 2 + mod) % mod;
        }
        return dp[nextVisit.length - 1];
    }
}