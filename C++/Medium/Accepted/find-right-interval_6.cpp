class Solution {
public:
    vector<int> findRightInterval(vector<vector<int>>& intervals) {
        
        vector<pair<int, int>> start;
        vector<int> ans(intervals.size(), -1);
        for(int i = 0; i < intervals.size(); i++) {
            start.push_back({intervals[i][0], i});
        }
        sort(start.begin(), start.end());
        for(int i = 0; i < intervals.size(); i++) {
            int lo = 0;
            int hi = start.size() - 1;
            while(lo < hi) {
                int mid = (lo + hi) / 2;
                if(start[mid].first < intervals[i][1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if(start[lo].first >= intervals[i][1]) {
                ans[i] = start[lo].second;
            }
        }
        return ans;
    }
};