class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        if (n < 2) return n;
        sort(intervals.begin(), intervals.end(), [](auto a, auto b) {
            return a[1] < b[1];
        });
        int ans = 1;
        int end = intervals[0][1];
        for (auto& interval : intervals) {
            if (interval[0] > end) {
                ans++;
                end = interval[1];
            }
        }
        return ans;
    }
};