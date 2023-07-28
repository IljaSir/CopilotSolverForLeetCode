class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b) {
            return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);
        });
        int ans = 1;
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][1] <= end) {
                continue;
            }
            end = intervals[i][1];
            ans++;
        }
        return ans;
    }
};