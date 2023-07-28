class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<int> result(n, 0);
        vector<vector<int>> graph(n);
        for (auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        vector<bool> visited(n, false);
        dfs(0, graph, labels, visited, result);
        return result;
    }
    vector<int> dfs(int root, vector<vector<int>>& graph, string& labels, vector<bool>& visited, vector<int>& result) {
        visited[root] = true;
        vector<int> count(26, 0);
        count[labels[root] - 'a']++;
        for (auto node : graph[root]) {
            if (!visited[node]) {
                vector<int> subCount = dfs(node, graph, labels, visited, result);
                for (int i = 0; i < 26; i++) {
                    count[i] += subCount[i];
                }
            }
        }
        result[root] = count[labels[root] - 'a'];
        return count;
    }
};