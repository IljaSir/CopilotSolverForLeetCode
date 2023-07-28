class Solution {
public:
    int minPushBox(vector<vector<char>>& grid) {
        
        int m = grid.size(), n = grid[0].size();
        int si = -1, sj = -1, bi = -1, bj = -1, ti = -1, tj = -1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'S') {
                    si = i;
                    sj = j;
                }
                if (grid[i][j] == 'B') {
                    bi = i;
                    bj = j;
                }
                if (grid[i][j] == 'T') {
                    ti = i;
                    tj = j;
                }
            }
        }
        vector<vector<bool>> visited(m, vector<bool>(n));
        queue<vector<int>> q;
        q.push({bi, bj, si, sj});
        visited[bi][bj] = true;
        int ans = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                auto cur = q.front();
                q.pop();
                int bi = cur[0], bj = cur[1], si = cur[2], sj = cur[3];
                if (bi == ti && bj == tj) {
                    return ans;
                }
                for (int k = 0; k < 4; ++k) {
                    int ni = bi + dirs[k][0], nj = bj + dirs[k][1];
                    int nsi = bi - dirs[k][0], nsj = bj - dirs[k][1];
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n || grid[ni][nj] == '#') {
                        continue;
                    }
                    if (ni == si && nj == sj) {
                        if (nsi < 0 || nsi >= m || nsj < 0 || nsj >= n || grid[nsi][nsj] == '#') {
                            continue;
                        }
                        if (!visited[ni][nj]) {
                            visited[ni][nj] = true;
                            q.push({ni, nj, bi, bj});
                        }
                    }
                    else {
                        if (!visited[ni][nj]) {
                            visited[ni][nj] = true;
                            q.push({ni,
    }
};