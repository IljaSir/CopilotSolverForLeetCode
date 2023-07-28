class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& con : connections) {
            graph[con[0]].push_back(con[1]);
            graph[con[1]].push_back(con[0]);
        }
        vector<vector<int>> res;
        vector<int> dfn(n, -1);
        vector<int> low(n, -1);
        int time = 0;
        function<void(int, int)> dfs = [&](int cur, int pre) {
            dfn[cur] = low[cur] = time++;
            for (auto& nxt : graph[cur]) {
                if (nxt == pre) continue;
                if (dfn[nxt] == -1) {
                    dfs(nxt, cur);
                    low[cur] = min(low[cur], low[nxt]);
                    if (low[nxt] > dfn[cur]) {
                        res.push_back({cur, nxt});
                    }
                } else {
                    low[cur] = min(low[cur], dfn[nxt]);
                }
            }
        };
        dfs(0, -1);
        return res;
    }
};