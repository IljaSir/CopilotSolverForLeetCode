class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        vector<int> dp(n, 1);
        sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[1] < b[1];
        });
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (intervals[j][1] < intervals[i][0]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};