class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        if (n == 0) return 0;
        sort(intervals.begin(), intervals.end(), [](const auto& a, const auto& b) {
            if (a[1] == b[1]) return a[0] < b[0];
            return a[1] < b[1];
        });
        int res = 0;
        int end = intervals[0][1];
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] < end) {
                ++res;
            } else {
                end = intervals[i][1];
            }
        }
        return res;
    }
};