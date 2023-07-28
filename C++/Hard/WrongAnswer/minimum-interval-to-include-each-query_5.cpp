class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        vector<int> res;
        sort(intervals.begin(), intervals.end(), [](auto& a, auto& b) {
            return a[1] < b[1];
        });
        sort(queries.begin(), queries.end());
        int n = intervals.size(), m = queries.size();
        int i = 0, j = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        while (j < m) {
            while (i < n && intervals[i][1] <= queries[j]) {
                pq.push({intervals[i][1] - intervals[i][0] + 1, intervals[i][0]});
                i++;
            }
            while (!pq.empty() && pq.top().second > queries[j]) {
                pq.pop();
            }
            res.push_back(pq.empty() ? -1 : pq.top().first);
            j++;
        }
        return res;
    }
};