class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        
        vector<vector<int>> ret;
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        for (const auto& interval : intervals) {
            if (ret.empty() || ret.back()[1] < interval[0]) {
                ret.push_back(interval);
            }
            else {
                ret.back()[1] = max(ret.back()[1], interval[1]);
            }
        }
        return ret;
    }
};