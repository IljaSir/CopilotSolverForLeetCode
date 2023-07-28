class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        
        int rows = matrix.size();
        if (rows == 0) return 0;
        int cols = matrix[0].size();
        vector<vector<int>> left(rows, vector<int>(cols));
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < cols; ++j) {
            vector<int> up(rows), down(rows);
            stack<int> stk;
            for (int i = 0; i < rows; ++i) {
                while (!stk.empty() && left[stk.top()][j] >= left[i][j]) {
                    stk.pop();
                }
                up[i] = stk.empty() ? -1 : stk.top();
                stk.push(i);
            }
            stk = stack<int>();
            for (int i = rows - 1; i >= 0; --i) {
                while (!stk.empty() && left[stk.top()][j] >= left[i][j]) {
                    stk.pop();
                }
                down[i] = stk.empty() ? rows : stk.top();
                stk.push(i);
            }
            for (int i = 0; i < rows; ++i) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ans = max(ans, area);
            }
        }
        return ans;
    }
};