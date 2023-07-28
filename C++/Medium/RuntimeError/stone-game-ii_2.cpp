class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        
        int n = piles.size();
        vector<int> s(n + 1);
        for (int i = n - 1; i >= 0; --i) {
            s[i] = s[i + 1] + piles[i];
        }
        vector<vector<int>> f(n, vector<int>(n));
        for (int i = n - 1; i >= 0; --i) {
            for (int m = 1; m <= n; ++m) {
                for (int x = 1; x <= 2 * m && i + x <= n; ++x) {
                    f[i][m] = max(f[i][m], s[i] - f[i + x][max(m, x)]);
                }
            }
        }
        return f[0][1];
    }
};