class Solution {
public:
    int totalNQueens(int n) {
        
        vector<int> pos;
        int ret = 0;
        dfs(n, 0, pos, ret);
        return ret;
    }
    void dfs(int n, int row, vector<int>& pos, int& ret) {
        if (row == n) {
            ret++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(pos, row, col)) {
                pos.push_back(col);
                dfs(n, row + 1, pos, ret);
                pos.pop_back();
            }
        }
    }
    bool isValid(vector<int>& pos, int row, int col) {
        for (int i = 0; i < pos.size(); i++) {
            if (pos[i] == col || abs(row - i) == abs(col - pos[i])) {
                return false;
            }
        }
        return true;
    }
};