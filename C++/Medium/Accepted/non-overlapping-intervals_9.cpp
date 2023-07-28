class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b){return a[1] < b[1];});
        int i = 0;
        int count = 0;
        for (int j = 1; j < intervals.size(); j++) {
            if (intervals[i][1] > intervals[j][0]) {
                count++;
            } else {
                i = j;
            }
        }
        return count;
    }
};