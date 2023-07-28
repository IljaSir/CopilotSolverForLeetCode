class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> graph(n);
        for (auto& r : roads) {
            graph[r[0]].push_back(r[1]);
            graph[r[1]].push_back(r[0]);
        }
        vector<int> visited(n, 0);
        visited[0] = 1;
        int max_total = 0;
        for (int i = 1; i <= n; ++i) {
            int total = 0;
            for (int j = 0; j < n; ++j) {
                if (visited[j] == 1) {
                    total += i;
                    visited[j] = 2;
                    for (auto& v : graph[j]) {
                        if (visited[v] == 0) {
                            visited[v] = 1;
                        }
                    }
                }
            }
            max_total = max(max_total, total);
        }
        return max_total;
    }
};