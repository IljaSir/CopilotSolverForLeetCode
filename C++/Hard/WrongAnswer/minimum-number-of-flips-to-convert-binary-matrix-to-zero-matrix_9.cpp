class Solution {
public:
    int minFlips(vector<vector<int>>& mat) {
        
        int n = mat.size(), m = mat[0].size();
        int end = 1 << (n * m), ans = -1;
        unordered_map<int, int> dist;
        dist[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int x = q.front();
            q.pop();
            if (x == end - 1) {
                ans = dist[x];
                break;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int y = x ^ (1 << (i * m + j));
                    if (i > 0) {
                        y ^= (1 << ((i - 1) * m + j));
                    }
                    if (i < n - 1) {
                        y ^= (1 << ((i + 1) * m + j));
                    }
                    if (j > 0) {
                        y ^= (1 << (i * m + j - 1));
                    }
                    if (j < m - 1) {
                        y ^= (1 << (i * m + j + 1));
                    }
                    if (!dist.count(y)) {
                        dist[y] = dist[x] + 1;
                        q.push(y);
                    }
                }
            }
        }
        return ans;
    }
};