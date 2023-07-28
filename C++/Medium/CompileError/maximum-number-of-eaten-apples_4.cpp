class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        int n = apples.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (apples[i] > 0) {
                q.push({i + days[i], apples[i]});
            }
            while (!q.empty() && q.top().first <= i) {
                q.pop();
            }
            if (!q.empty()) {
                ans++;
                if (--q.top().second == 0) {
                    q.pop();
                }
            }
        }
        int day = n;
        while (!q.empty()) {
            auto [d, a] = q.top(); q.pop();
            ans += min(d - day, a);
            day = d;
        }
        return ans;
    }
};