class Solution {
public:
    int longestPath(vector<int>& parent, string s) {
        
        int n = s.size();
        vector<vector<int>> adj(n);
        for (int i = 1; i < n; ++i) {
            adj[parent[i]].push_back(i);
        }
        return dfs(adj, 0, s);
    }
    int dfs(vector<vector<int>>& adj, int u, string& s) {
        int res = 0;
        int mx1 = 0, mx2 = 0;
        for (int v : adj[u]) {
            int len = dfs(adj, v, s);
            if (s[v] != s[u]) {
                if (len >= mx1) {
                    mx2 = mx1;
                    mx1 = len;
                } else if (len > mx2) {
                    mx2 = len;
                }
            }
        }
        return mx1 + mx2 + 1;
    }
};