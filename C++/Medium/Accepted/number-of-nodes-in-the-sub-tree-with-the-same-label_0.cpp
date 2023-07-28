class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<vector<int>> adj(n);
        for (auto& e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> ans(n);
        vector<int> visited(n);
        dfs(0, adj, labels, ans, visited);
        return ans;
    }
    
    vector<int> dfs(int node, vector<vector<int>>& adj, string& labels, vector<int>& ans, vector<int>& visited) {
        visited[node] = 1;
        vector<int> cnt(26);
        for (auto& v : adj[node]) {
            if (!visited[v]) {
                auto sub = dfs(v, adj, labels, ans, visited);
                for (int i = 0; i < 26; ++i) cnt[i] += sub[i];
            }
        }
        ans[node] = ++cnt[labels[node] - 'a'];
        return cnt;
    }
};