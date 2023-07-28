class Solution {
public:
    int totalNQueens(int n) {
        
        int ans = 0;
        vector<int> state(n, -1);
        dfs(state, 0, ans);
        return ans;
    }
    void dfs(vector<int>& state, int row, int& ans) {
        if (row == state.size()) {
            ans++;
            return;
        }
        for (int i = 0; i < state.size(); i++) {
            if (isValid(state, row, i)) {
                state[row] = i;
                dfs(state, row + 1, ans);
                state[row] = -1;
            }
        }
    }
    bool isValid(vector<int>& state, int row, int col) {
        for (int i = 0; i < state.size(); i++) {
            if (state[i] == col) return false;
            if (abs(i - row) == abs(state[i] - col)) return false;
        }
        return true;
    }
};