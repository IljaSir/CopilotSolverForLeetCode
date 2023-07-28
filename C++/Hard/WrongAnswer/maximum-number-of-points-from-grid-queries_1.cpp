class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> prefix(m+1, vector<int>(n+1, 0));
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = grid[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        vector<int> res;
        for (int q : queries) {
            int cnt = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int x = min(m, i + q / grid[i-1][j-1] - 1);
                    int y = min(n, j + q / grid[i-1][j-1] - 1);
                    if (x < i || y < j) continue;
                    if (prefix[x][y] - prefix[x][j-1] - prefix[i-1][y] + prefix[i-1][j-1] > cnt) {
                        cnt = prefix[x][y] - prefix[x][j-1] - prefix[i-1][y] + prefix[i-1][j-1];
                    }
                }
            }
            res.push_back(cnt);
        }
        return res;
    }
};