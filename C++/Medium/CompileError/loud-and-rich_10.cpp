class Solution {
public:
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        vector<int> ans(n, -1);
        vector<vector<int>> adj(n);
        for (auto& e : richer) {
            adj[e[1]].push_back(e[0]);
        }
        for (int i = 0; i < n; ++i) {
            dfs(adj, quiet, i, ans);
        }
        return ans;
    }
};