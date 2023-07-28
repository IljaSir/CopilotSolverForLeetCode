class Solution {
public:
    int maximumGood(vector<vector<int>>& statements) {
        
        int n = statements.size();
        vector<vector<int>> g(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (statements[i][j] == 1)
                    g[i][j] = 1;
        int res = 0;
        for (int i = 0; i < (1 << n); ++i) {
            int cnt = 0;
            for (int j = 0; j < n; ++j)
                if (i & (1 << j)) ++cnt;
            bool ok = true;
            for (int j = 0; j < n; ++j)
                if (i & (1 << j))
                    for (int k = 0; k < n; ++k)
                        if (i & (1 << k)) {
                            if (g[j][k] == 0) {
                                ok = false;
                                break;
                            }
                        }
            if (ok) res = max(res, cnt);
        }
        return res;
    }
};