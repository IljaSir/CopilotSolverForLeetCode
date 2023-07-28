class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        vector<bool> row(n, false);
        vector<bool> col(n, false);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] > n) return false;
                row[matrix[i][j] - 1] = true;
                col[matrix[j][i] - 1] = true;
            }
            for(int j = 0; j < n; j++) {
                if(!row[j] || !col[j]) return false;
            }
            fill(row.begin(), row.end(), false);
            fill(col.begin(), col.end(), false);
        }
        return true;
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        int n = board.size();
        vector<vector<int>> matrix(n, vector<int>(n, 0));
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') continue;
                matrix[i][j] = board[i][j] - '0';
            }
        }
        return checkValid(matrix);
    }
};