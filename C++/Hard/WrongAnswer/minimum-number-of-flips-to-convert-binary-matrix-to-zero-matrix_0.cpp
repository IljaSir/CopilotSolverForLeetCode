class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        int start = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start |= mat[i][j] << (i * n + j);
            }
        }
        if (start == 0) return 0;
        queue<int> q;
        q.push(start);
        unordered_set<int> seen;
        seen.insert(start);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int cur = q.front();
                q.pop();
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        int next = cur;
                        for (int x = -1; x <= 1; x++) {
                            for (int y = -1; y <= 1; y++) {
                                if (abs(x) == abs(y)) continue;
                                int nx = j + x, ny = k + y;
                                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                                next ^= (1 << (nx * n + ny));
                            }
                        }
                        if (next == 0) return step;
                        if (seen.count(next)) continue;
                        q.push(next);
                        seen.insert(next);
                    }
                }
            }
        }
        return -1;
    }
};