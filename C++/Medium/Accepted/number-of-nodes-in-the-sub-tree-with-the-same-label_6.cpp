class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<int> ans(n, 0);
        vector<vector<int>> graph(n, vector<int>());
        for (auto& edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<int> visited(n, 0);
        dfs(graph, visited, labels, 0, ans);
        return ans;
    }
    vector<int> dfs(vector<vector<int>>& graph, vector<int>& visited, string& labels, int index, vector<int>& ans) {
        vector<int> count(26, 0);
        visited[index] = 1;
        for (auto& v : graph[index]) {
            if (!visited[v]) {
                vector<int> c = dfs(graph, visited, labels, v, ans);
                for (int i = 0; i < 26; ++i) {
                    count[i] += c[i];
                }
            }
        }
        ++count[labels[index] - 'a'];
        ans[index] = count[labels[index] - 'a'];
        return count;
    }
};