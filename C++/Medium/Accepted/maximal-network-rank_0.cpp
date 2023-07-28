class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> graph(n, vector<int>(n, 0));
        vector<int> degree(n, 0);
        for (auto& road : roads) {
            graph[road[0]][road[1]] = 1;
            graph[road[1]][road[0]] = 1;
            degree[road[0]]++;
            degree[road[1]]++;
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxRank = max(maxRank, degree[i] + degree[j] - graph[i][j]);
            }
        }
        return maxRank;
    }
};