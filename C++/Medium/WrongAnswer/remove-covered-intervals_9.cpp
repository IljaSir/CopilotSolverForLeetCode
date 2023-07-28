class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        vector<int> res;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            for (; j < n; j++) {
                if (intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
                    break;
                }
            }
            if (j == n) {
                res.push_back(i);
            }
        }
        return res.size();
    }
};