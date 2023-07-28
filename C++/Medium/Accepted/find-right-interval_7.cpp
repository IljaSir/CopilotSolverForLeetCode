class Solution {
public:
    vector<int> findRightInterval(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        vector<int> res(n, -1);
        map<int, int> start2index;
        vector<int> starts;
        for (int i = 0; i < n; ++i) {
            start2index[intervals[i][0]] = i;
            starts.push_back(intervals[i][0]);
        }
        sort(starts.begin(), starts.end());
        for (int i = 0; i < n; ++i) {
            int target = intervals[i][1];
            auto it = lower_bound(starts.begin(), starts.end(), target);
            if (it != starts.end()) {
                res[i] = start2index[*it];
            }
        }
        return res;
    }
};