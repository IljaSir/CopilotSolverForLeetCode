class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        
        int count = 0;
        int row = grid.size();
        int col = grid[0].size();
        for(int i = 0; i < row - 2; i++) {
            for(int j = 0; j < col - 2; j++) {
                if(grid[i + 1][j + 1] != 5) continue;
                if(grid[i][j] + grid[i][j + 1] + grid[i][j + 2] != 15) continue;
                if(grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2] != 15) continue;
                if(grid[i][j] + grid[i + 1][j] + grid[i + 2][j] != 15) continue;
                if(grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2] != 15) continue;
                if(grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) continue;
                if(grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15) continue;
                vector<int> v;
                v.push_back(grid[i][j]);
                v.push_back(grid[i][j + 1]);
                v.push_back(grid[i][j + 2]);
                v.push_back(grid[i + 1][j]);
                v.push_back(grid[i + 1][j + 1]);
                v.push_back(grid[i + 1][j + 2]);
                v.push_back(grid[i + 2][j]);
                v.push_back(grid[i + 2][j + 1]);
                v.push_back(grid[i + 2][j + 2]);
                sort(v.begin(), v.end());
                if(v[0] == 1 && v[1] == 2 && v[2] == 3 && v[3] == 4 && v[4] == 5 && v[5] == 6 && v[6] == 7 && v[7] == 8 && v[8] == 9
    }
};