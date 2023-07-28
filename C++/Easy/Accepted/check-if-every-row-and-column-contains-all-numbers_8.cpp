class Solution {
public:
    bool checkValid(vector<vector<int>>& matrix) {
        
        int n = matrix.size();
        vector<unordered_set<int>> row(n);
        vector<unordered_set<int>> col(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(row[i].find(matrix[i][j])!=row[i].end()) return false;
                row[i].insert(matrix[i][j]);
                if(col[j].find(matrix[i][j])!=col[j].end()) return false;
                col[j].insert(matrix[i][j]);
            }
        }
        return true;
    }
    bool isValidSudoku(vector<vector<char>>& board) {
        int n = board.size();
        vector<vector<int>> matrix(n, vector<int>(n));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = board[i][j]-'0';
            }
        }
        return checkValid(matrix);
    }
};