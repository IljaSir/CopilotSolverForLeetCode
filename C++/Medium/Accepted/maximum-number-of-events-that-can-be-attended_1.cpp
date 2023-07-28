class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end());
        int n = events.size();
        priority_queue<int, vector<int>, greater<int>> pq;
        int res = 0;
        int i = 0;
        for (int d = 1; d <= 100000; d++) {
            while (!pq.empty() && pq.top() < d) pq.pop();
            while (i < n && events[i][0] == d) pq.push(events[i++][1]);
            if (!pq.empty()) {
                pq.pop();
                res++;
            }
        }
        return res;
    }
};