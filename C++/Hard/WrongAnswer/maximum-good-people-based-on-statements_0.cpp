class Solution {
public:
    int maximumGood(vector<vector<int>>& statements) {
        
        int n = statements.size();
        vector<vector<int>> g(n, vector<int>(n, 0));
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (statements[i][j] == 2) continue;
                g[i][j] = statements[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < (1 << n); ++i) {
            vector<int> st(n, 0);
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) st[j] = 1;
            }
            bool flag = true;
            for (int j = 0; j < n; ++j) {
                if (!st[j]) continue;
                for (int k = 0; k < n; ++k) {
                    if (j == k) continue;
                    if (g[j][k] == 1 && !st[k]) {
                        flag = false;
                        break;
                    }
                    if (g[j][k] == 0 && st[k]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) ans = max(ans, __builtin_popcount(i));
        }
        return ans;
    }
};