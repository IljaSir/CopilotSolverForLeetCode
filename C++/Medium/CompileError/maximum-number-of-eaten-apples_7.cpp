class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        
        int n = apples.size();
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int i = 0, ans = 0;
        while (i < n || !pq.empty()) {
            if (i < n && apples[i] > 0) {
                pq.push({i + days[i], apples[i]});
            }
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