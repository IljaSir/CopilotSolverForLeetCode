class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        
        int n = apples.size();
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
        int ans = 0;
        for (int i = 0; i < n || !q.empty(); ++i) {
            if (i < n && apples[i] > 0) {
                q.emplace(i + days[i], apples[i]);
            }
            while (!q.empty() && (q.top().first <= i || q.top().second == 0)) {
                q.pop();
            }
            if (!q.empty()) {
                --q.top().second;
                ++ans;
            }
        }
        return ans;
    }
};