class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        
        vector<vector<int>> grid(n, vector<int>(n, 1));
        for (auto m : mines) {
            grid[m[0]][m[1]] = 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int k = 1;
                    while (i - k >= 0 && i + k < n && j - k >= 0 && j + k < n && grid[i - k][j] == 1 && grid[i + k][j] == 1 && grid[i][j - k] == 1 && grid[i][j + k] == 1) {
                        k++;
                    }
                    res = max(res, k);
                }
            }
        }
        return res;
    }
};