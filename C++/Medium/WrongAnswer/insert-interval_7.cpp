class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        
        vector<vector<int>> res;
        for (int i = 0; i < intervals.size(); ++i) {
            if (newInterval[0] < intervals[i][0]) {
                intervals.insert(intervals.begin() + i, newInterval);
                break;
            }
        }
        if (intervals.size() == 0 || newInterval[0] > intervals.back()[0]) {
            intervals.push_back(newInterval);
        }
        res.push_back(intervals[0]);
        for (int i = 1; i < intervals.size(); ++i) {
            if (res.back()[1] >= intervals[i][0]) {
                res.back()[1] = max(res.back()[1], intervals[i][1]);
            } else {
                res.push_back(intervals[i]);
            }
        }
        return res;
    }
};