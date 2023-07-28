class Solution {
public:
    int countLatticePoints(vector<vector<int>>& circles) {
        
        int n = circles.size();
        int m = 100;
        vector<vector<int>> grid(m+1, vector<int>(m+1, 0));
        for (int i = 0; i < n; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            for (int j = x-r; j <= x+r; j++) {
                for (int k = y-r; k <= y+r; k++) {
                    if (j >= 0 && j <= m && k >= 0 && k <= m) {
                        if ((j-x)*(j-x) + (k-y)*(k-y) <= r*r) {
                            grid[j][k] = 1;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                if (grid[i][j]) {
                    res++;
                }
            }
        }
        return res;
    }
};