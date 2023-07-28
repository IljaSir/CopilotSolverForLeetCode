class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
 n; ++i){
            jobs[i][0] = e[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        sort(jobs.bgin(), jobsend(), [](const vector<int>& a, cont vector<nt>& b) {
            return a[1] < b[1];
        });
        map<int, int> dp;
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            int cur = prev(dp.upper_bound(jobs[i][0]))->second + jobs[i][2];
            if (cur > dp.rbegin()->second) {
                dp[jobs[i][1]] = cur;
            }
        }
        return dp.rbegin()->second;
    }
};