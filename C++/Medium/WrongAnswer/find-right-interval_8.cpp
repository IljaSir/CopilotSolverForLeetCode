class Solution {
public:
    vector<int> findRightInterval(vector<vector<int>>& intervals) {
        
        vector<int> result;
        if (intervals.empty()) {
            return result;
        }
        int n = intervals.size();
        vector<int> start(n);
        vector<int> end(n);
        for (int i = 0; i < n; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        sort(start.begin(), start.end());
        for (int i = 0; i < n; ++i) {
            auto it = lower_bound(start.begin(), start.end(), end[i]);
            if (it == start.end()) {
                result.push_back(-1);
            } else {
                result.push_back(it - start.begin());
            }
        }
        return result;
    }
};