class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        int n = intervals.size();
        vector<int> ans(queries.size());
        vector<pair<int, int>> query;
        for (int i = 0; i < queries.size(); ++i) {
            query.push_back({queries[i], i});
        }
        sort(query.begin(), query.end());
        sort(intervals.begin(), intervals.end());
        set<pair<int, int>> s;
        int i = 0;
        for (auto q : query) {
            while (i < n && intervals[i][0] <= q.first) {
                s.insert({intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                ++i;
            }
            while (s.size() && s.begin()->second < q.first) {
                s.erase(s.begin());
            }
            ans[q.second] = s.size() ? s.begin()->first : -1;
        }
        return ans;
    }
};