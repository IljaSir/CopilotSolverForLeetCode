class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [&](const auto& a, const auto& b) {
            return a[0] < b[0];
        });
        priority_queue<int, vector<int>, greater<int>> pq;
        int i = 0, n = events.size(), res = 0, d = 1;
        while (i < n || !pq.empty()) {
            if (pq.empty()) d = events[i][0];
            while (i < n && events[i][0] == d) {
                pq.push(events[i++][1]);
            }
            pq.pop();
            ++res;
            ++d;
            while (!pq.empty() && pq.top() < d) pq.pop();
        }
        return res;
    }
};