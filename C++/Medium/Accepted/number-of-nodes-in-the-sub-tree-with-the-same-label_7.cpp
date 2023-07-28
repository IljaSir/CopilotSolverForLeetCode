class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<int> ans(n, 0);
        vector<vector<int>> adj(n, vector<int>());
        for (auto e : edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        vector<int> visited(n, 0);
        dfs(0, labels, adj, visited, ans);
        return ans;
    }
    vector<int> dfs(int i, string& labels, vector<vector<int>>& adj, vector<int>& visited, vector<int>& ans) {
        vector<int> count(26, 0);
        visited[i] = 1;
        count[labels[i] - 'a']++;
        for (auto j : adj[i]) {
            if (visited[j] == 0) {
                vector<int> subCount = dfs(j, labels, adj, visited, ans);
                for (int k = 0; k < 26; k++) {
                    count[k] += subCount[k];
                }
            }
        }
        ans[i] = count[labels[i] - 'a'];
        return count;
    }
};