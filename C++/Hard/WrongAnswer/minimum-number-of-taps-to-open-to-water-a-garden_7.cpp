class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        
        vector<pair<int, int>> intervals;
        for (int i = 0; i <= n; i++) {
            if (ranges[i] > 0) intervals.push_back({i - ranges[i], i + ranges[i]});
        }
        sort(intervals.begin(), intervals.end());
        int ans = 0, left = 0, right = 0, i = 0;
        while (left <= n) {
            while (i < intervals.size() && intervals[i].first <= left) {
                right = max(right, intervals[i++].second);
            }
            if (left == right) return -1;
            left = right;
            ans++;
        }
        return ans;
    }
};