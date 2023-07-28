class Solution {
public:
    int minGroups(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b){
            return a[1] < b[1];
        });
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] > pre) {
                ans++;
                pre = intervals[i][1];
            }
        }
        return ans;
    }
};