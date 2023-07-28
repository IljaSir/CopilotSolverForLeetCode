class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        
        vector<vector<int>> intervals;
        for(int i = 0; i < ranges.size(); i++) {
            int l = max(0, i - ranges[i]);
            int r = min(n, i + ranges[i]);
            intervals.push_back({l, r});
        }
        sort(intervals.begin(), intervals.end());
        int ans = 0;
        int max_right = 0;
        int i = 0;
        while(i < intervals.size() && max_right < n) {
            int cur_right = max_right;
            while(i < intervals.size() && intervals[i][0] <= max_right) {
                cur_right = max(cur_right, intervals[i][1]);
                i++;
            }
            if(cur_right == max_right) return -1;
            max_right = cur_right;
            ans++;
        }
        return max_right >= n ? ans : -1;
    }
};