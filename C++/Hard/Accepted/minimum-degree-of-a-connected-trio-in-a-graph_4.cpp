class Solution {
public:
    int minTrioDegree(int n, vector<vector<int>>& edges) {
        
        vector<int> degrees(n + 1, 0);
        vector<vector<bool>> graph(n + 1, vector<bool>(n + 1, false));
        for (auto& e : edges) {
            degrees[e[0]]++;
            degrees[e[1]]++;
            graph[e[0]][e[1]] = true;
            graph[e[1]][e[0]] = true;
        }
        int ans = INT_MAX;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (graph[i][j] && graph[i][k] && graph[j][k]) {
                        ans = min(ans, degrees[i] + degrees[j] + degrees[k] - 6);
                    }
                }
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};