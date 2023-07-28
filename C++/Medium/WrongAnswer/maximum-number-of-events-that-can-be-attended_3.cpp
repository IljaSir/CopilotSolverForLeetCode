class Solution {
public:
    int maxEvents(vector<vector<int>>& events) {
        
        int n = events.size();
        sort(events.begin(), events.end(), [](auto& a, auto& b) {
            return a[1] < b[1];
        });
        priority_queue<int, vector<int>, greater<int>> pq;
        int ans = 0, i = 0, day = 1;
        while (i < n || !pq.empty()) {
            if (pq.empty()) {
                day = events[i][0];
            }
            while (i < n && events[i][0] <= day) {
                pq.push(events[i++][1]);
            }
            pq.pop();
            ++day;
            ++ans;
            while (!pq.empty() && pq.top() < day) {
                pq.pop();
            }
        }
        return ans;
    }
};