class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        
        vector<vector<int>> result;
        bool isInserted = false;
        for (int i = 0; i < intervals.size(); ++i) {
            if (isInserted || newInterval[1] < intervals[i][0]) {
                result.push_back(intervals[i]);
            } else if (newInterval[0] > intervals[i][1]) {
                result.push_back(intervals[i]);
            } else {
                newInterval[0] = min(newInterval[0], intervals[i][0]);
                newInterval[1] = max(newInterval[1], intervals[i][1]);
            }
        }
        if (!isInserted) {
            result.push_back(newInterval);
        }
        sort(result.begin(), result.end());
        return result;
    }
};