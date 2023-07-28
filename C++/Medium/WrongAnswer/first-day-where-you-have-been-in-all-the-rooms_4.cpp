class Solution {
public:
    int firstDayBeenInAllRooms(vector<int>& nextVisit) {
        
        int n = nextVisit.size();
        int mod = 1000000007;
        vector<long> dp(n, 0);
        for (int i = 1; i < n; i++) {
            dp[i] = (dp[i - 1] + 2 * (i - nextVisit[i]) + 2) % mod;
        }
        return dp[n - 1];
    }
};