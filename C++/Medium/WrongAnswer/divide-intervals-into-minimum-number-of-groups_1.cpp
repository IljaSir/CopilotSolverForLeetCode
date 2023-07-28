class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](auto& a, auto& b) {
            return a[0] < b[0];
        });
        int ans = 0;
        for (int i = 0; i < intervals.size(); i++) {
            int r = intervals[i][1];
            while (i + 1 < intervals.size() && r >= intervals[i + 1][0]) {
                r = min(r, intervals[i + 1][1]);
                i++;
            }
            ans++;
        }
        return ans;
    }
};