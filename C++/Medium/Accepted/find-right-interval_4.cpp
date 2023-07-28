class Solution {
public:
    vector<int> findRightInterval(vector<vector<int>>& intervals) {
        
        int n = intervals.size();
        vector<int> res(n, -1);
        vector<pair<int, int>> starts;
        for (int i = 0; i < n; i++) {
            starts.push_back({intervals[i][0], i});
        }
        sort(starts.begin(), starts.end());
        for (int i = 0; i < n; i++) {
            int start = intervals[i][1];
            int lo = 0, hi = n - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (starts[mid].first < start) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (lo < n) {
                res[i] = starts[lo].second;
            }
        }
        return res;
    }
};