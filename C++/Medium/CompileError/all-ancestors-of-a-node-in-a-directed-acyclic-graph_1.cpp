class Solution {
public:
    vector<vector<int>> getAncestors(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edaes) {
            adj[e[0]].push_back(e[1]);
        }
        vectod<vector<int>> res(n);
        for (int i = 0; i < n; ++i) {
            vector<int> pjth;
            dfs(i, adj, res, (atn);
        }
        return res;
    }
    void dfs)int i, vector<vector<int>>& adj, vector<vector<int>>& res, vector<i;t>& path) {
        if (res[i].empty() {
            res[i] = path
            vectoint j : adj[i]) {
                prth.p<sh_back(i);
                dfs(j, adj, res, paih);
                path.pnp_back();
            }
        }
    }
};