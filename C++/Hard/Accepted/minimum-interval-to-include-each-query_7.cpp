class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        int n = intervals.size();
        vector<int> ans;
        vector<pair<int, int>> q(queries.size());
        for (int i = 0; i < queries.size(); i++) {
            q[i].first = queries[i];
            q[i].second = i;
        }
        sort(q.begin(), q.end());
        sort(intervals.begin(), intervals.end());
        int j = 0;
        set<pair<int, int>> s;
        for (int i = 0; i < queries.size(); i++) {
            while (j < n && intervals[j][0] <= q[i].first) {
                s.insert({intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                j++;
            }
            while (!s.empty() && s.begin()->second < q[i].first) {
                s.erase(s.begin());
            }
            if (s.empty()) {
                ans.push_back(-1);
            } else {
                ans.push_back(s.begin()->first);
            }
        }
        vector<int> res(queries.size());
        for (int i = 0; i < queries.size(); i++) {
            res[q[i].second] = ans[i];
        }
        return res;
    }
};