class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b){
            if(a[0] == b[0]) return a[1] > b[1];
            return a[0] < b[0];
        });
        int ans = 0;
        int l = -1, r = -1;
        for(auto& v : intervals){
            if(v[1] > r){
                ans++;
                l = v[0];
                r = v[1];
            }
        }
        return ans;
    }
};