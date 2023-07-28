class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b) {
            return a[1] < b[1];
        });
        int res = 0;
        int cur = INT_MIN;
        for (auto interval : intervals) {
            if (interval[0] >= cur) {
                res++;
                cur = interval[1];
            }
        }
        return intervals.size() - res;
    }
};