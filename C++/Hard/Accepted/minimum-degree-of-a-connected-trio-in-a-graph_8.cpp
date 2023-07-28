class Solution {
public:
    int minTrioDegree(int n, vector<vector<int>>& edges) {
        
        vector<vector<int>> mat(n+1, vector<int>(n+1));
        vector<int> degree(n+1);
        for (auto& edge: edges) {
            int u = edge[0], v = edge[1];
            mat[u][v] = mat[v][u] = 1;
            degree[u]++;
            degree[v]++;
        }
        int ans = INT_MAX;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (mat[i][j] == 0) continue;
                for (int k = j+1; k <= n; k++) {
                    if (mat[i][k] == 0 || mat[j][k] == 0) continue;
                    ans = min(ans, degree[i] + degree[j] + degree[k] - 6);
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};