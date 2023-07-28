class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<int> ans(n, 0);
        vector<vector<int>> graph(n, vector<int>());
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<bool> visited(n, false);
        dfs(0, graph, labels, visited, ans);
        return ans;
    }
    vector<int> dfs(int node, vector<vector<int>>& graph, string& labels, vector<bool>& visited, vector<int>& ans) {
        visited[node] = true;
        vector<int> count(26, 0);
        count[labels[node] - 'a']++;
        for (auto child : graph[node]) {
            if (!visited[child]) {
                auto childCount = dfs(child, graph, labels, visited, ans);
                for (int i = 0; i < 26; i++) {
                    count[i] += childCount[i];
                }
            }
        }
        ans[node] = count[labels[node] - 'a'];
        return count;
    }
};