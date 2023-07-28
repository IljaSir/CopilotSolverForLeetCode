class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<vector<int>> adj(n);
        vector<int> res(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> visited(n);
        dfs(0, adj, labels, visited, res);
        return res;
    }
    vector<int> dfs(int root, vector<vector<int>>& adj, string& labels, vector<int>& visited, vector<int>& res) {
        vector<int> cnt(26);
        visited[root] = 1;
        for (auto& v : adj[root]) {
            if (!visited[v]) {
                auto sub = dfs(v, adj, labels, visited, res);
                for (int i = 0; i < 26; ++i) {
                    cnt[i] += sub[i];
                }
            }
        }
        cnt[labels[root] - 'a']++;
        res[root] = cnt[labels[root] - 'a'];
        return cnt;
    }
};