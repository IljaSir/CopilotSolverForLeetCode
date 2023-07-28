class Solution {
public:
    int firstDayBeenInAllRooms(vector<int>& nextVisit) {
        
        int n = nextVisit.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; ++i) {
            dp[i] = (dp[i - 1] + dp[i] + 2) % 1000000007;
            if (nextVisit[i] < i - 1) {
                dp[i] = (dp[i] - dp[nextVisit[i]] + 1000000007) % 1000000007;
            }
        }
        return dp[n - 1];
    }
};