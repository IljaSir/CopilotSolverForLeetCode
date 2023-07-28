class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<vector<int>> adj(n);
        for(auto& edge: edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        vector<int> ans(n, 1);
        vector<int> count(26);
        vector<bool> visited(n, false);
        visited[0] = true;
        dfs(0, adj, labels, count, visited, ans);
        return ans;
    }
    
    void dfs(int node, vector<vector<int>>& adj, string& labels, vector<int>& count, vector<bool>& visited, vector<int>& ans) {
        count[labels[node] - 'a']++;
        for(auto& child: adj[node]) {
            if(!visited[child]) {
                visited[child] = true;
                dfs(child, adj, labels, count, visited, ans);
                ans[node] += ans[child];
            }
        }
        count[labels[node] - 'a']--;
    }
};