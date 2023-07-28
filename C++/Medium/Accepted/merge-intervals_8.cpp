class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        
        vector<vector<int>> result;
        sort(intervals.begin(), intervals.end());
        int i = 0;
        while (i < intervals.size()) {
            int j = i + 1;
            while (j < intervals.size() && intervals[j][0] <= intervals[i][1]) {
                intervals[i][1] = max(intervals[i][1], intervals[j][1]);
                j++;
            }
            result.push_back(intervals[i]);
            i = j;
        }
        return result;
    }
};