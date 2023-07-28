class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        int res = 0, curr = 0;
        sort(intervals.begin(), intervals.end(), [](auto& a, auto& b) {
            return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);
        });
        for (auto& interval : intervals) {
            if (interval[1] > curr) {
                curr = interval[1];
                res++;
            }
        }
        return res;
    }
};