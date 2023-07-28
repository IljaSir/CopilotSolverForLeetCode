class Solution {
public:
    int totalNQueens(int n) {
        
        int result = 0;
        vector<int> queens(n, -1);
        solve(queens, 0, result);
        return result;
    }
    
    void solve(vector<int>& queens, int row, int& result) {
        int n = queens.size();
        if (row == n) {
            result++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            if (isValid(queens, row, col)) {
                queens[row] = col;
                solve(queens, row + 1, result);
                queens[row] = -1;
            }
        }
    }
    
    bool isValid(vector<int>& queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || abs(queens[i] - col) == abs(i - row)) {
                return false;
            }
        }
        return true;
    }
};