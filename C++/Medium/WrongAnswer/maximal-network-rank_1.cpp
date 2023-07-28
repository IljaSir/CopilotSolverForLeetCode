class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> graph(n, vector<int>(n, 0));
        for (auto& road : roads) {
            graph[road[0]][road[1]]++;
            graph[road[1]][road[0]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int count = graph[i][j];
                for (int k = 0; k < n; ++k) {
                    count += graph[i][k] > 0;
                    count += graph[j][k] > 0;
                }
                ans = max(ans, count);
            }
        }
        return ans;
    }
};