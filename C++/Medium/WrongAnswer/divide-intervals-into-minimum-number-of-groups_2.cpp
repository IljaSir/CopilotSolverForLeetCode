class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b){
            return a[1] < b[1];
        });
        int ans = 0;
        int last = INT_MIN;
        for (auto& interval : intervals) {
            if (interval[0] > last) {
                ans++;
                last = interval[1];
            }
        }
        return ans;
    }
};