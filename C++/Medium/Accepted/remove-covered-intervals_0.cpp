class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);
        });
        int ans = 0;
        int maxEnd = -1;
        for (auto& interval: intervals) {
            if (interval[1] > maxEnd) {
                ans++;
                maxEnd = interval[1];
            }
        }
        return ans;
    }
};