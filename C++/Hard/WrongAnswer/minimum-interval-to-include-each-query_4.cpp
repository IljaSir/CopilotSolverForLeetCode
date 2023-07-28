class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        int n = intervals.size();
        vector<int> res(queries.size(), -1);
        vector<pair<int, int>> q;
        for (int i = 0; i < queries.size(); i++) {
            q.push_back({queries[i], i});
        }
        sort(q.begin(), q.end());
        sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[1] - a[0] < b[1] - b[0];
        });
        set<pair<int, int>> s;
        int j = 0;
        for (int i = 0; i < q.size(); i++) {
            while (j < n && intervals[j][0] <= q[i].first) {
                s.insert({intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                j++;
            }
            while (!s.empty() && s.begin()->second < q[i].first) {
                s.erase(s.begin());
            }
            if (!s.empty()) {
                res[q[i].second] = s.begin()->first;
            }
        }
        return res;
    }
};