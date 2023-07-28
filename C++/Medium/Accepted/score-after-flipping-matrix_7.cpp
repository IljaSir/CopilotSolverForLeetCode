class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
        
        int row = grid.size();
        int col = grid[0].size();
        int ans = 0;
        for (int i=0; i<row; i++) {
            if (grid[i][0] == 0) {
                for (int j=0; j<col; j++) {
                    grid[i][j] = 1 - grid[i][j];
                }
            }
        }
        for (int j=0; j<col; j++) {
            int cnt = 0;
            for (int i=0; i<row; i++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
            ans += max(cnt, row - cnt) * pow(2, col - j - 1);
        }
        return ans;
    }
};