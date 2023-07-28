class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        int start_i = -1;
        int start_j = -1;
        int key_cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '@') {
                    start_i = i;
                    start_j = j;
                }
                if (grid[i][j] >= 'a' && grid[i][j] <= 'f') {
                    key_cnt++;
                }
            }
        }
        vector<vector<vector<int>>> visited(m, vector<vector<int>>(n, vector<int>(1 << 6, 0)));
        visited[start_i][start_j][0] = 1;
        queue<vector<int>> q;
        q.push({start_i, start_j, 0});
        int step = 1;
        while (!q.empty()) {
            int q_size = q.size();
            for (int i = 0; i < q_size; i++) {
                auto pos = q.front();
                q.pop();
                int i = pos[0];
                int j = pos[1];
                int keys = pos[2];
                for (int k = 0; k < 4; k++) {
                    int ni = i + dirs[k][0];
                    int nj = j + dirs[k][1];
                    if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                        continue;
                    }
                    if (grid[ni][nj] == '#') {
                        continue;
                    }
                    int nkeys = keys;
                    if (grid[ni][nj] >= 'a' && grid[ni][nj] <= 'f') {
                        nkeys = keys | (1 << (grid[ni][nj] - 'a'));
                    }
                    if (grid[ni][nj] >= 'A' && grid[ni][nj] <= 'F') {
                        if ((keys & (1 << (grid[ni][nj] - 'A'))) == 0) {
                            continue;
                        }
                    }
                    if (visited[ni][nj][nkeys] == 0) {
                        visited[ni][nj][nkeys] = 1;
                        q.push({ni, nj,
    }
};