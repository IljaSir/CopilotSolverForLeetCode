class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        
        vector<vector<int>> grid(n, vector<int>(n, 1));
        for (auto& mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        vector<vector<int>> left(n, vector<int>(n, 0));
        vector<vector<int>> right(n, vector<int>(n, 0));
        vector<vector<int>> top(n, vector<int>(n, 0));
        vector<vector<int>> bottom(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                    top[i][j] = (i == 0 ? 0 : top[i - 1][j]) + 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 1) {
                    right[i][j] = (j == n - 1 ? 0 : right[i][j + 1]) + 1;
                    bottom[i][j] = (i == n - 1 ? 0 : bottom[i + 1][j]) + 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    result = max(result, min(min(left[i][j], right[i][j]), min(top[i][j], bottom[i][j])));
                }
            }
        }
        return result;
    }
};