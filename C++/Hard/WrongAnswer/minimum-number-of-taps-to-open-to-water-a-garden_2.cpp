class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        
        vector<pair<int, int>> intervals;
        for (int i = 0; i < ranges.size(); i++) {
            if (ranges[i] > 0) {
                intervals.push_back({i - ranges[i], i + ranges[i]});
            }
        }
        sort(intervals.begin(), intervals.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
            return a.first < b.first;
        });
        int count = 0;
        int start = 0;
        while (start < intervals.size()) {
            int maxEnd = INT_MIN;
            int i = start;
            while (i < intervals.size() && intervals[i].first <= intervals[start].first) {
                maxEnd = max(maxEnd, intervals[i].second);
                i++;
            }
            count++;
            if (maxEnd >= n) {
                return count;
            }
            if (i == start) {
                return -1;
            }
            start = i;
        }
        return -1;
    }
};