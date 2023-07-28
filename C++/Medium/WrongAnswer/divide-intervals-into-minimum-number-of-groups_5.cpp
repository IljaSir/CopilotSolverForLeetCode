class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b) {
            return a[0] < b[0];
        });
        int res = 0;
        int prev = -1;
        for (auto& interval : intervals) {
            if (interval[0] > prev) {
                ++res;
                prev = interval[1];
            } else {
                prev = min(prev, interval[1]);
            }
        }
        return res;
    }
};