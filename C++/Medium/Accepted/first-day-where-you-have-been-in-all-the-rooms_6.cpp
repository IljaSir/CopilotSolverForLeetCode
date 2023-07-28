class Solution {
public:
    int firstDayBeenInAllRooms(vector<int>& nextVisit) {
        
        int mod = 1e9+7;
        int n = nextVisit.size();
        vector<long long> dp(n, 0);
        for(int i = 1; i < n; i++){
            dp[i] = (2 * dp[i-1] - dp[nextVisit[i-1]] + 2 + 2*mod) % mod;
        }
        return dp[n-1];
    }
};