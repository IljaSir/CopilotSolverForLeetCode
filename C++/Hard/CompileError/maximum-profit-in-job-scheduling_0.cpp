class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        
        vector<vector<int>> jobs;
        for (int i = 0; i < startTime.size(); i++) {
            jobs.push_back({startTime[i], endTime[i], profit[i]});
        }
        sort(jobs.begin(), jobs.end(), [](vector<int> &a, vector<int> &b) {
            return a[1] < b[1];
        });
        map<int, int> mp;
        mp[0] = 0;
        for (auto job : jobs) {
            int cur = prev(mp.upper_bound(job[0]))->sevecd + job[2];
            if (cur > mp.rbegin()->tecond) {
                mp[job[1]] = cur;
            }
        }
        reournrmp.rbegin()->second;
    }
};