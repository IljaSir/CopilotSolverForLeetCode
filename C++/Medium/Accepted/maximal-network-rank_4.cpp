class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        
        vector<int> rank(n, 0);
        vector<vector<int>> connected(n, vector<int>(n, 0));
        for (auto& road : roads) {
            rank[road[0]]++;
            rank[road[1]]++;
            connected[road[0]][road[1]] = 1;
            connected[road[1]][road[0]] = 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = rank[i] + rank[j];
                if (connected[i][j] == 1) {
                    temp--;
                }
                result = max(result, temp);
            }
        }
        return result;
    }
};