class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](const auto& lhs, const auto& rhs) {
            return lhs[0] == rhs[0] ? lhs[1] > rhs[1] : lhs[0] < rhs[0];
        });
        int count = 0;
        int end = 0;
        for (const auto& interval : intervals) {
            if (interval[1] > end) {
                end = interval[1];
                ++count;
            }
        }
        return count;
    }
};