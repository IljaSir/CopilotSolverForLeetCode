class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        int m = matrix[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    int val = matrix[i][j];
                    if(val < 1 || val > n) return false;
                    for(int k = 0; k < n; k++) {
                        if(matrix[i][k] == val) {
                            if(visited[i][k]) return false;
                            visited[i][k] = true;
                        }
                    }
                    for(int k = 0; k < m; k++) {
                        if(matrix[k][j] == val) {
                            if(visited[k][j]) return false;
                            visited[k][j] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();
        vector<vector<int>> matrix(n, vector<int>(m, 0));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == '.') matrix[i][j] = 0;
                else matrix[i][j] = board[i][j] - '0';
            }
        }
        return checkValid(matrix);
    }
};