class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        
        vector<vector<int>> matrix(n, vector<int>(n, 0));
        vector<int> degree(n, 0);
        for (auto& road : roads) {
            matrix[road[0]][road[1]] = 1;
            matrix[road[1]][road[0]] = 1;
            ++degree[road[0]];
            ++degree[road[1]];
        }
        int maxRank = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int rank = degree[i] + degree[j];
                if (matrix[i][j]) {
                    --rank;
                }
                maxRank = max(maxRank, rank);
            }
        }
        return maxRank;
    }
};