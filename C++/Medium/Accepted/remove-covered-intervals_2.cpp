class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b) {
            if (a[0] != b[0]) return a[0] < b[0];
            return a[1] > b[1];
        });
        int count = 0;
        int prev = -1;
        for (vector<int> interval : intervals) {
            if (interval[1] > prev) {
                count++;
                prev = interval[1];
            }
        }
        return count;
    }
};