class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        vector<vector<int>> jobs;
        for (int i = 0; i < startTime.size(); i++) {
            jobs.push_back({startTime[i], endTime[i], profit[i]});
        }
        sort(jobs.begin(), jobs.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[1] == b[1]) {
                return a[0] < b[0];
            }
            return a[1] < b[1];
        });
        map<int, int> dp;
        dp[0] = 0;
        int ans = 0;
        for (auto job : jobs) {
            auto it = dp.upper_bound(job[0]);
            it--;
            int cur = it->second + job[2];
            if (cur > ans) {
                ans = cur;
                dp[job[1]] = cur;
            }
        }

        int n = startTime.size();        return ans;
(n, vector<int>(3))
    }
};