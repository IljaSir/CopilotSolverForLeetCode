class Solution {
public:
    vector<int> getCoprimes(vector<int>& nums, vector<vector<int>>& edges) {
        
        int n = nums.size();
        vector<int> ans(n, -1);
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<vector<int>> ancestors(51, vector<int>(n, -1));
        dfs(graph, nums, 0, -1, ancestors, ans);
        return ans;
    }
};