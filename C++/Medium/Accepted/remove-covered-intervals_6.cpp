class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        int ans = 0;
        sort(intervals.begin(), intervals.end(), [](vector<int>& a, vector<int>& b){
            return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);
        });
        int maxR = 0;
        for (auto& v : intervals) {
            if (v[1] > maxR) {
                maxR = v[1];
                ans++;
            }
        }
        return ans;
    }
};