class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        
        int n = apples.size();
        int ans = 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        for (int i = 0; i < n; i++) {
            if (apples[i] > 0) {
                pq.push({i + days[i], apples[i]});
            }
            while (!pq.empty() && (pq.top().first <= i || pq.top().second == 0)) {
                pq.pop();
            }
            if (!pq.empty()) {
                ans++;
                pq.top().second--;
            }
        }
        int i = n;
        while (!pq.empty()) {
            while (!pq.empty() && (pq.top().first <= i || pq.top().second == 0)) {
                pq.pop();
            }
            if (!pq.empty()) {
                ans++;
                pq.top().second--;
            }
            i++;
        }
        return ans;
    }
};