class Solution {
public:
    int ways(vector<string>& pizza, int k) {
        
        int rows = pizza.size();
        int cols = pizza[0].size();
        vector<vector<int>> apple(rows + 1, vector<int>(cols + 1, 0));
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                apple[i + 1][j + 1] = apple[i + 1][j] + apple[i][j + 1] - apple[i][j] + (pizza[i][j] == 'A');
            }
        }
        vector<vector<vector<int>>> dp(rows, vector<vector<int>>(cols, vector<int>(k + 1, 0)));
        return dfs(apple, dp, 0, 0, k);
    }
};