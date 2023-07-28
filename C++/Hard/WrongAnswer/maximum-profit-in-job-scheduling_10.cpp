class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        vector<vector<int>> jobs;
        for (int i = 0; i < startTime.size(); i++) {
            jobs.push_back({startTime[i], endTime[i], profit[i]});
        }
        sort(jobs.begin(), jobs.end());
        map<int, int> dp;
        dp[0] = 0;
        for (auto job : jobs) {
            auto it = prev(dp.upper_bound(job[0]));
            int cur = it->second + job[2];
            if (cur > dp.rbegin()->second) {
                dp[job[1]] = cur;
            }
        }
        return dp.rbegin()->second;
    }
};