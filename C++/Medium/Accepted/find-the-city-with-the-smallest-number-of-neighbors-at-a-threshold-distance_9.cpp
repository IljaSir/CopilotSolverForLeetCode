class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        
        vector<vector<int>> graph(n, vector<int>(n, INT_MAX));
        for (auto &e: edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
        for (int i = 0; i < n; ++i) {
            graph[i][i] = 0;
        }
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (graph[i][k] != INT_MAX && graph[k][j] != INT_MAX && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        int min = INT_MAX, ans = -1;
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (graph[i][j] <= distanceThreshold) {
                    ++count;
                }
            }
            if (count <= min) {
                min = count;
                ans = i;
            }
        }
        return ans;
    }
};