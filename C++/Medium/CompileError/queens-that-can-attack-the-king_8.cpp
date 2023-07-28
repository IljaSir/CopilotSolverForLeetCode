class Solution {
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        
        int n = queens.size();
        vector<vector<int>> ans;
        vector<vector<int>> board(8, vector<int>(8, 0));
        for (int i = 0; i < n; ++i) {
            board[queens[i][0]][queens[i][1]] = 1;
        }
        int x = king[0], y = king[1];
        int i = x, j = y;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                ans.push_back({i, j});
                break;
            }
            --i;
            --j;
        }
        i = x;
        j = y;
        while (i >= 0 && j < 8) {
            if (board[i][j] == 1) {
                ans.push_back({i, j});
                break;
            }
            --i;
            ++j;
        }
        i = x;
        j = y;
        while (i < 8 && j >= 0) {
            if (board[i][j] == 1) {
                ans.push_back({i, j});
                break;
            }
            ++i;
            --j;
        }
        i = x;
        j = y;
        while (i < 8 && j < 8) {
            if (board[i][j] == 1) {
                ans.push_back({i, j});
                break;
            }
            ++i;
            ++j;
        }
        i = x;
        j = y;
        while (i >= 0) {
            if (board[i][j] == 1) {
                ans.push_back({i, j});
                break;
            }
            --i;
        }
        i = x;
        j = y;
        while (i < 8) {
            if (board[i][j] == 1) {
                ans.push_back({i, j});
                break;
            }
            ++i;
        }
        i = x;
        j = y;
        while (j >= 0) {
            if (board[i][j] == 1) {
                ans.push_back({i, j});
                break;
            }
            --j;
        }
        i = x;
        j = y;
        while (j <
    }
};