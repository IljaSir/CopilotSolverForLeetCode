class Solution {
public:
    int deleteGreatestValue(vector<vector<int>>& grid) {
        
        int row = grid.size();
        int col = grid[0].size();
        int max = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }
    int maxSum(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        int max = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }
    int maximumSum(vector<vector<int>>& grid) {
        int row = grid.size();
        int col = grid[0].size();
        int max = 0;
        int sum = 0;
        int count = col;
        while(count > 0) {
            max = deleteGreatestValue(grid);
            sum += max;
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(grid[i][j] == max) {
                        grid[i].erase(grid[i].begin()+j);
                        break;
                    }
                }
            }
            count--;
        }
        return sum;
    }
};