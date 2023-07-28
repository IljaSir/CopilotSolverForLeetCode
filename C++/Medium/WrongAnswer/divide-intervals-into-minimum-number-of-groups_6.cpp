class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        vector<int> dp(n+1, 0);
        sort(intervals.begin(), intervals.end(), [](auto& a, auto& b) {
            return a[1] < b[1];
        });
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i-1];
            for (int j = i-1; j >= 0; --j) {
                if (intervals[j][1] < intervals[i-1][0]) {
                    dp[i] = max(dp[i], dp[j]+1);
                    break;
                }
            }
        }
        return dp[n];
    }
};