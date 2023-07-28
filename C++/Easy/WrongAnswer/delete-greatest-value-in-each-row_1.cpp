class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int answer = 0;
        while (n > 0) {
            int max = 0;
            for (int i = 0; i < m; ++i) {
                int maxInRow = 0;
                int index = 0;
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] > maxInRow) {
                        maxInRow = grid[i][j];
                        index = j;
                    }
                }
                grid[i][index] = 0;
                if (maxInRow > max) {
                    max = maxInRow;
                }
            }
            answer += max;
            --n;
        }
        return answer;
    }
};