class Solution {
public:
    int maximumRows(vector<vector<int>>& matrix, int numSelect) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            if (__builtin_popcount(i) != numSelect) continue;
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                bool ok = true;
                for (int k = 0; k < n; k++) {
                    if (matrix[j][k] == 1 && !(i & (1 << k))) {
                        ok = false;
                        break;
                    }
                }
                if (ok) cnt++;
            }
            res = max(res, cnt);
        }
        return res;
    }
};