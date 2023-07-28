class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        
        int n = apples.size();
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
        int res = 0;
        for (int i = 0; i < n || !pq.empty(); ++i) {
            if (i < n && apples[i] > 0) { pq.push({i + days[i], apples[i]}); }
            while (!pq.empty() && (pq.top().first <= i || pq.top().second == 0)) { pq.pop(); }
            if (!pq.empty()) {
                ++res;
                --pq.top().second;
            }
        }
        return res;
    }
};