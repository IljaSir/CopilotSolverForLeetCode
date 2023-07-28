class Solution {
public:
    int minTrioDegree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> G(n);
        vector<int> degree(n);
        for (auto& e : edges) {
            G[e[0] - 1].push_back(e[1] - 1);
            G[e[1] - 1].push_back(e[0] - 1);
            degree[e[0] - 1]++;
            degree[e[1] - 1]++;
        }
        int minDegree = INT_MAX;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (G[i][j] && G[i][k] && G[j][k]) {
                        minDegree = min(minDegree, degree[i] + degree[j] + degree[k] - 6);
                    }
                }
            }
        }
        return minDegree == INT_MAX ? -1 : minDegree;
    }
};