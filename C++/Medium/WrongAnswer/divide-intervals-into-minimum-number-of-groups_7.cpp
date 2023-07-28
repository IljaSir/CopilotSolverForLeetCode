class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        vector<int> dp(n+1, 0);
        sort(intervals.begin(), intervals.end());
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] < intervals[i][0]) {
                    dp[i] = max(dp[i], dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }
};