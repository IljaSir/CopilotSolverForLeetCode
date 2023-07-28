class Solution {
public:
    vector<int> minInterval(vector<vector<int>>& intervals, vector<int>& queries) {
        
        sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b) {
            return a[1] < b[1];
        });
        sort(queries.begin(), queries.end());
        vector<int> res(queries.size());
        int i = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for (int j = 0; j < queries.size(); j++) {
            while (i < intervals.size() && intervals[i][1] <= queries[j]) {
                pq.push({intervals[i][1] - intervals[i][0] + 1, intervals[i][0]});
                i++;
            }
            while (!pq.empty() && pq.top().second > queries[j]) {
                pq.pop();
            }
            res[j] = (pq.empty()) ? -1 : pq.top().first;
        }
        return res;
    }
};