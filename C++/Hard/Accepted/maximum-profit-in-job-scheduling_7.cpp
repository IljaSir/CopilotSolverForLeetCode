class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        int n = startTime.size();
        vector<vector<int>> jobs(n, vector<int>(3, 0));
        for (int i = 0; i < n; ++i) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        sort(jobs.begin(), jobs.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        vector<int> dp(n, 0);
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; ++i) {
            int l = 0, r = i - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (jobs[mid][1] <= jobs[i][0]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            dp[i] = max(dp[i - 1], (l > 0 ? dp[l - 1] : 0) + jobs[i][2]);
        }
        return dp.back();
    }
};