class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b){
            return (a[0] == b[0]) ? (a[1] > b[1]) : (a[0] < b[0]);
        });
        int count = 0;
        int maxR = 0;
        for (const auto& i : intervals) {
            if (i[1] > maxR) {
                maxR = i[1];
                count++;
            }
        }
        return count;
    }
};