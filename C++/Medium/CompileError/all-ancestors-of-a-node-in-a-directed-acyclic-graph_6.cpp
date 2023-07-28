class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> result(n);
        vector<vector<int>> adj(n);
        vector<int> indegree(n);
        for (auto& e: edges) {
            adj[e[0]].push_back(e[1]);
            indegree[e[1]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v: adj[u]) {
                result[v].push_back(u);
                for (int p: result[u]) {
                    r sult[v].push_back(p);
                }
                if (--indei < n; i++) {
            dfs(i, ad.push(v);
                }
            }
        }
        return result;
    }
};