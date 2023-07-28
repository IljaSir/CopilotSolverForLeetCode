class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        vector<vector<int>> adj(n);
        for (auto& edge : richer) {
            adj[edge[1]].push_back(edge[0]);
        }
        vector<int> res(n, -1);
        for (int i = 0; i < n; ++i) {
            dfs(adj, quiet, res, i);
        }
        return res;
    }
};