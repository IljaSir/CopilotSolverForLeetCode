class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        int n = queries.size();
        vector<int> ans(n, -1);
        vector<vector<int>> q(n, vector<int>(2));
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }
        sort(intervals.begin(), intervals.end());
        sort(q.begin(), q.end());
        int j = 0;
        set<pair<int, int>> s;
        for (int i = 0; i < n; i++) {
            while (j < intervals.size() && intervals[j][0] <= q[i][0]) {
                s.insert({intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                j++;
            }
            while (s.size() && s.begin()->second < q[i][0]) {
                s.erase(s.begin());
            }
            if (s.size()) {
                ans[q[i][1]] = s.begin()->first;
            }
        }
        return ans;
    }
};