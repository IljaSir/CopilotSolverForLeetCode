class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> graph(n);
        vector<vector<int>> ans(n);
        vector<int> inDegree(n, 0);
        for (auto &e : edges) {
            graph[e[0]].push_back(e[1]);
            ++inDegree[e[1]];
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v : graph[u]) {
                ans[v].push_back(u);
                for (int a : ans[u]) {
                    ans[v].push_back(a);
                }
                sort(ans[v].begin(), ans[v].end());
                --inDegree[v];
                if (inDegree[v] == 0) {
                    q.push(v);
                }
            }
        }
        return ans;
    }
};