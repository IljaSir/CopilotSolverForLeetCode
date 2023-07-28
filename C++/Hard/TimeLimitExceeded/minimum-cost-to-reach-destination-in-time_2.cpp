class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {
        
        int n = passingFees.size();
        vector<vector<pair<int, int>>> g(n);
        for (auto& e : edges) {
            g[e[0]].push_back({e[1], e[2]});
            g[e[1]].push_back({e[0], e[2]});
        }
        vector<vector<int>> f(n, vector<int>(maxTime + 1, INT_MAX / 2));
        f[0][0] = passingFees[0];
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> q;
        q.push({f[0][0], 0, 0});
        while (!q.empty()) {
            auto t = q.top();
            q.pop();
            int cost = t[0], x = t[1], time = t[2];
            if (cost > f[x][time]) continue;
            for (auto& e : g[x]) {
                int y = e.first, w = e.second;
                if (time + w <= maxTime) {
                    if (f[y][time + w] > f[x][time] + passingFees[y]) {
                        f[y][time + w] = f[x][time] + passingFees[y];
                        q.push({f[y][time + w], y, time + w});
                    }
                }
            }
        }
        int res = INT_MAX;
        for (int i = 0; i <= maxTime; i++) {
            res = min(res, f[n - 1][i]);
        }
        return res == INT_MAX / 2 ? -1 : res;
    }
};