class Solution {
public:
    int largestMagicSquare(vector<vector<int>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> rowSum(m, vector<int>(n, 0));
        vector<vector<int>> colSum(m, vector<int>(n, 0));
        vector<vector<int>> diagSum1(m, vector<int>(n, 0));
        vector<vector<int>> diagSum2(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j] = grid[i][j] + (j > 0 ? rowSum[i][j - 1] : 0);
                colSum[i][j] = grid[i][j] + (i > 0 ? colSum[i - 1][j] : 0);
                diagSum1[i][j] = grid[i][j] + (i > 0 && j > 0 ? diagSum1[i - 1][j - 1] : 0);
                diagSum2[i][j] = grid[i][j] + (i > 0 && j < n - 1 ? diagSum2[i - 1][j + 1] : 0);
            }
        }
        // for (auto row : rowSum) {
        //     for (auto i : row) {
        //         cout << i << " ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;
        // for (auto row : colSum) {
        //     for (auto i : row) {
        //         cout << i << " ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;
        // for (auto row : diagSum1) {
        //     for (auto i : row) {
        //         cout << i << " ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;
        // for (auto row : diagSum2) {
        //     for (auto i : row) {
        //         cout << i << " ";
        //     }
        //     cout << endl;
        // }
        // cout << endl;
        int ans = 1;
        for (int i = 0; i <
    }
};