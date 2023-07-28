class Solution {
public:
    int countUnguarded(int m, int n, vector<vector<int>>& guards, vector<vector<int>>& walls) {
        
        vector<vector<bool>> grid(m, vector<bool>(n, false));
        
        for(auto g : guards) {
            grid[g[0]][g[1]] = true;
        }
        
        for(auto w : walls) {
            grid[w[0]][w[1]] = true;
        }
        
        int count = 0;
        
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == false) {
                    count++;
                }
            }
        }
        
        return count;
    }
};