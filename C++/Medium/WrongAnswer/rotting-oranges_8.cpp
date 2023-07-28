class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int rows = grid.size();
        int columns = grid[0].size();
        int freshOranges = 0;
        queue<pair<int, int>> rottenOranges;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    rottenOranges.push({i, j});
                }
            }
        }
        int minutes = 0;
        vector<vector<int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!rottenOranges.empty()) {
            int size = rottenOranges.size();
            for (int i = 0; i < size; i++) {
                pair<int, int> current = rottenOranges.front();
                rottenOranges.pop();
                for (int j = 0; j < 4; j++) {
                    int nextRow = current.first + directions[j][0];
                    int nextColumn = current.second + directions[j][1];
                    if (nextRow >= 0 && nextRow < rows && nextColumn >= 0 && nextColumn < columns) {
                        if (grid[nextRow][nextColumn] == 1) {
                            grid[nextRow][nextColumn] = 2;
                            rottenOranges.push({nextRow, nextColumn});
                            freshOranges--;
                        }
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes - 1 : -1;
    }
};