class Solution {
public:
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        
        vector<vector<int>> graph(n);
        for (auto& edge : connections) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> pre(n, -1), low(n, -1);
        vector<vector<int>> res;
        int time = 0;
        function<void(int, int)> dfs = [&](int cur, int parent) {
            pre[cur] = low[cur] = time++;
            for (int nxt : graph[cur]) {
                if (pre[nxt] == -1) {
                    dfs(nxt, cur);
                    low[cur] = min(low[cur], low[nxt]);
                    if (low[nxt] > pre[cur]) {
                        res.push_back({cur, nxt});
                    }
                } else if (nxt != parent) {
                    low[cur] = min(low[cur], pre[nxt]);
                }
            }
        };
        dfs(0, -1);
        return res;
    }
};