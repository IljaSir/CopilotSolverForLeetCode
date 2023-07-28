class Solution {
public:
    int orderOfLargestPlusSign(int n, vector<vector<int>>& mines) {
        
        vector<vector<int>> grid(n, vector<int>(n, 1));
        for (auto &mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0, cnt = 0; j < n; ++j) {
                cnt = grid[i][j] == 0 ? 0 : cnt + 1;
                dp[i][j] = cnt;
            })));n[i][j])));
                }
            }
        }
        return ans;
    }
};