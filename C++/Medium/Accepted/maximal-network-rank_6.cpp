class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        
        vector<int> in(n, 0);
        vector<vector<int>> graph(n, vector<int>(n, 0));
        for (auto& r : roads) {
            graph[r[0]][r[1]] = 1;
            graph[r[1]][r[0]] = 1;
            in[r[0]]++;
            in[r[1]]++;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = max(res, in[i] + in[j] - graph[i][j]);
            }
        }
        return res;
    }
};