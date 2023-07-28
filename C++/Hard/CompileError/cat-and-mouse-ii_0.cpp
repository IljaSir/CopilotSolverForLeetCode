class Solution {
public:
    bool canMouseWin(vector<string>& grid, int catJump, int mouseJump) {
        
        int m = grid.size(), n = grid[0].size();
        int cat = 0, mouse = 0, food = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'C') {
                    cat = i * n + j;
                } else if (grid[i][j] == 'M') {
                    mouse = i * n + j;
                } else if (grid[i][j] == 'F') {
                    food = i * n + j;
                }
            }
        }
        unordered_map<int, int> memo;
        return dfs(grid, cat, mouse, food, catJump, mouseJump, memo);
    }
};