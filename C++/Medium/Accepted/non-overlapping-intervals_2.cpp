class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        
        if (intervals.size() == 0) return 0;
        sort(intervals.begin(), intervals.end(), [](auto& a, auto& b) {
            return a[1] < b[1];
        });
        int ans = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals[i][0] >= end) {
                ++ans;
                end = intervals[i][1];
            }
        }
        return intervals.size() - ans;
    }
};