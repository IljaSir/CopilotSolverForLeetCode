class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<int> res(n, 0);
        unordered_map<int, vector<int>> adj;
        for (auto &e: edges) {
            adj[e[0]].push_back(e[1]);
            adj[e[1]].push_back(e[0]);
        }
        dfs(adj, labels, res, 0, -1);
        return res;
    }
};