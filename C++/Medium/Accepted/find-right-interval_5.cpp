class Solution {
public:
    vector<int> findRightInterval(vector<vector<int>>& intervals) {
        
        vector<int> ans;
        int n = intervals.size();
        if (n == 1) {
            ans.push_back(-1);
            return ans;
        }
        vector<pair<int, int>> v;
        for (int i = 0; i < n; ++i) {
            v.push_back(make_pair(intervals[i][0], i));
        }
        sort(v.begin(), v.end());
        for (int i = 0; i < n; ++i) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (v[mid].first >= intervals[i][1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (v[r].first >= intervals[i][1]) {
                ans.push_back(v[r].second);
            } else {
                ans.push_back(-1);
            }
        }
        return ans;
    }
};