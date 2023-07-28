class Solution {
public:
    bool isPossible(int n, vector<vector<int>>& edges) {
        
        vector<int> degree(n + 1, 0);
        vector<vector<int>> graph(n + 1, vector<int>());
        for (const auto &edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        vector<int> odd;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2) {
                odd.push_back(i);
            }
        }
        if (odd.size() == 0) {
            return true;
        }
        if (odd.size() % 2) {
            return false;
        }
        vector<int> visited(n + 1, 0);
        for (int i = 0; i < odd.size(); i += 2) {
            if (!dfs(odd[i], odd[i + 1], graph, visited)) {
                return false;
            }
        }
        return true;
    }
};