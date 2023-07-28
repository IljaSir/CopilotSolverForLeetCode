class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        vector<vector<int>> adj(n);
        for (auto& v : richer) {
            adj[v[1]].push_back(v[0]);
        }
        vector<int> res(n, -1);
        for (int i = 0; i < n; i++) {
            dfs(adj, quiet, res, i);
        }
        return res;
    }
    int dfs(vector<vector<int>>& adj, vector<int>& quiet, vector<int>& res, int i) {
        if (res[i] >= 0) return res[i];
        res[i] = i;
        for (int j : adj[i]) {
            if (quiet[res[i]] > quiet[dfs(adj, quiet, res, j)]) {
                res[i] = res[j];
            }
        }
        return res[i];
    }
};