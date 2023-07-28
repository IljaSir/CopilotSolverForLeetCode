class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        int n = intervals.size();
        int m = queries.size();
        vector<int> ans(m, -1);
        vector<pair<int, int>> q(m);
        for (int i = 0; i < m; ++i) {
            q[i] = {queries[i], i};
        }
        sort(q.begin(), q.end());
        sort(intervals.begin(), intervals.end());
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int i = 0;
        for (int j = 0; j < m; ++j) {
            while (i < n && intervals[i][0] <= q[j].first) {
                pq.push({intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                ++i;
            }
            while (!pq.empty() && pq.top().second < q[j].first) {
                pq.pop();
            }
            if (!pq.empty()) {
                ans[q[j].second] = pq.top().first;
            }
        }
        return ans;
    }
};