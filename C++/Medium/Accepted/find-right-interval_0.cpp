class Solution {
public:
    vector<int> findRightInterval(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        map<int, int> mp;
        for (int i = 0; i < n; ++i) {
            mp[intervals[i][0]] = i;
        }
        vector<int> ans;
        for (int i = 0; i < n; ++i) {
            auto it = mp.lower_bound(intervals[i][1]);
            if (it == mp.end()) {
                ans.push_back(-1);
            } else {
                ans.push_back(it->second);
            }
        }
        return ans;
    }
};