class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];
        });
        sort(queries.begin(), queries.end());
        vector<int> ans(queries.size(), -1);
        int i = 0, n = intervals.size();
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        for (int j = 0; j < queries.size(); ++j) {
            while (i < n && intervals[i][0] <= queries[j]) {
                pq.push({intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                ++i;
            }
            while (!pq.empty() && pq.top()[1] < queries[j]) {
                pq.pop();
            }
            if (!pq.empty()) {
                ans[j] = pq.top()[0];
            }
        }
        return ans;
    }
};