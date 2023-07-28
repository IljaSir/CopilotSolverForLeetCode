class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        int n = startTime.size();
        vector<vector<int>> jobs(n);
        for (int i = 0; i < n; i++) {
            jobs[i] = {startTime[i], endTime[i], profit[i]};
        }
        sort(jobs.begin(), jobs.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });
        vector<int> dp(n, 0);
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int p = jobs[i][2];
            int l = 0, r = i - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (jobs[m][1] <= jobs[i][0]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            if (l > 0) {
                p += dp[l - 1];
            }
            dp[i] = max(dp[i - 1], p);
        }
        return dp[n - 1];
    }
};