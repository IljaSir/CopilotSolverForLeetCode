class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        if (n <= 1) return 0;
        sort(intervals.begin(), intervals.end(), [](const auto& a, const auto& b) {
            return a[1] < b[1];
        });
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= end) {
                ++cnt;
                end = intervals[i][1];
            }
        }
        return n - cnt;
    }
};