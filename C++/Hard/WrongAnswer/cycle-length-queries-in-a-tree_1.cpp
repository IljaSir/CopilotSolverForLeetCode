class Solution {
public:
    vector<int> cycleLengthQueries(int n, vector<vector<int>>& queries) {
        
        // 1, 2, 3, 4, 5, 6, 7
        // 2, 4, 6, 8, 10, 12, 14
        // 3, 6, 9, 12, 15, 18, 21
        // 4, 8, 12, 16, 20, 24, 28
        // 5, 10, 15, 20, 25, 30, 35
        // 6, 12, 18, 24, 30, 36, 42
        // 7, 14, 21, 28, 35, 42, 49
        vector<int> ret;
        int m = queries.size();
        int N = (1 << n) - 1;
        vector<vector<int>> dist(N + 1, vector<int>(N + 1, 0));
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                dist[i][j] = dist[j][i] = __builtin_popcount(i ^ j);
            }
        }
        for (int i = 0; i < m; ++i) {
            int a = queries[i][0];
            int b = queries[i][1];
            int res = N;
            for (int j = 1; j <= N; ++j) {
                res = min(res, dist[a][j] + dist[b][j] + 1);
            }
            ret.push_back(res);
        }
        return ret;
    }
};