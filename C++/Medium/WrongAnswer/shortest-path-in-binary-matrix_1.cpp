class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        if (n == 1) return 1;
        queue<pair<int, int>> q;
        q.push({0, 0});
        grid[0][0] = 1;
        int ans = 1;
        int x[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int y[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        while (!q.empty()) {
            int size = q.size();
            ans++;
            while (size--) {
                auto p = q.front();
                q.pop();
                int i = p.first, j = p.second;
                if (i == n-1 && j == n-1) return ans;
                for (int k = 0; k < 8; k++) {
                    int r = i + x[k];
                    int c = j + y[k];
                    if (r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0) {
                        q.push({r, c});
                        grid[r][c] = 1;
                    }
                }
            }
        }
        return -1;
    }
};