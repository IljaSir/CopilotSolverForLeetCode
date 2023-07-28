class Solution {
public:
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        
        vector<int> ans(n, 0);
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> visited(n, 0);
        dfs(graph, visited, 0, labels, ans);
        return ans;
    }
    vector<int> dfs(vector<vector<int>>& graph, vector<int>& visited, int node, string& labels, vector<int>& ans) {
        if (visited[node]) return vector<int>(26, 0);
        visited[node] = 1;
        vector<int> count(26, 0);
        count[labels[node] - 'a']++;
        for (auto& next : graph[node]) {
            auto nextCount = dfs(graph, visited, next, labels, ans);
            for (int i = 0; i < 26; i++) {
                count[i] += nextCount[i];
            }
        }
        ans[node] = count[labels[node] - 'a'];
        return count;
    }
};