class Solution {
public:
    int findMinimumTime(vector<vector<int>>& tasks) {
        
        vector<pair<int, int>> time;
        for (auto& task : tasks) {
            time.push_back(make_pair(task[1], task[2]));
            time.push_back(make_pair(task[0] - 1, -task[2]));
        }
        sort(time.begin(), time.end());
        int ans = 0, cur = 0;
        for (auto& t : time) {
            cur += t.second;
            ans = max(ans, cur);
        }
        return ans;
    }
};