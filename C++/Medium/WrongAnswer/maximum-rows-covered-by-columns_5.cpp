class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size(), n = matrix[0].size();
        int res = 0;
        vector<int> cnt(1 << n, 0);
        for (int i = 0; i < m; ++i) {
            int state = 0;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j]) state |= (1 << j);
            }
            ++cnt[state];
        }
        for (int i = 0; i < n; ++i) {
            for (int state = (1 << n) - 1; state >= 0; --state) {
                if (state & (1 << i)) cnt[state ^ (1 << i)] += cnt[state];
            }
        }
        for (int state = 0; state < (1 << n); ++state) {
            if (__builtin_popcount(state) == numSelect) res = max(res, cnt[state]);
        }
        return res;
    }
};