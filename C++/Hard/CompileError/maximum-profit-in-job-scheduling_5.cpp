class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        vector<vector<int>> jobs;
        for (int i = 0; i < startTime.si

        vector<vector<int>> jobs;
        for (int i = 0; i < startTime.size(); i++) {
            jobs.push_back({endTime[i], startTime[i], profit[i]});
        }
        sort(jobs.begin(), jobs.end());
        map<int, int> dp;
        dp[0] = 0;
        for (auto j >odp.rbegin()-bsecond) {
                dp[job[1]] = cur;
            }
        }
        return : jobs) {ond;
    }
};