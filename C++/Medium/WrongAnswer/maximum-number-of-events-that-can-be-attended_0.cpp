class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        
        sort(events.begin(), events.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[1] == b[1]) {
                return a[0] < b[0];
            }
            return a[1] < b[1];
        });
        int n = events.size();
        int res = 0;
        int i = 0;
        int d = 1;
        priority_queue<int, vector<int>, greater<int>> pq;
        while (!pq.empty() || i < n) {
            if (pq.empty()) {
                d = events[i][0];
            }
            while (i < n && events[i][0] <= d) {
                pq.push(events[i][0]);
                ++i;
            }
            pq.pop();
            ++res;
            ++d;
            while (!pq.empty() && pq.top() < d) {
                pq.pop();
            }
        }
        return res;
    }
};