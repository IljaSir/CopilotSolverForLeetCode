class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        vector<int> ans;
        if (matrix.empty()) return ans;
        int m = matrix.size(), n = matrix[0].size();
        vector<vector<int>> visited(m, vector<int>(n));
        int i = 0, j = 0;
        int di = 0, dj = 1;
        for (int k = 0; k < m * n; k++) {
            ans.push_back(matrix[i][j]);
            visited[i][j] = 1;
            if (i + di >= 0 && i + di < m && j + dj >= 0 && j + dj < n && visited[i + di][j + dj] == 0) {
                i += di;
                j += dj;
            } else {
                int tmp = di;
                di = dj;
                dj = -tmp;
                i += di;
                j += dj;
            }
        }
        return ans;
    }
};