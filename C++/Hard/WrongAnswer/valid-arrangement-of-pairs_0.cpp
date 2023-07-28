class Solution {
public:
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        
        int n = pairs.size();
        vector<vector<int>> adj(n);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (pairs[i][1] == pairs[j][0]) {
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }
        vector<int> vis(n);
        vector<vector<int>> ans;
        vector<int> path;
        dfs(0, vis, adj, ans, path, pairs);
        return ans;
    }
    void dfs(int u, vector<int> &vis, vector<vector<int>> &adj, vector<vector<int>> &ans, vector<int> &path, vector<vector<int>> &pairs) {
        vis[u] = 1;
        path.push_back(u);
        if (path.size() == pairs.size()) {
            ans.push_back(path);
            vis[u] = 0;
            path.pop_back();
            return;
        }
        for (int v : adj[u]) {
            if (!vis[v]) {
                dfs(v, vis, adj, ans, path, pairs);
            }
        }
        vis[u] = 0;
        path.pop_back();
    }
};