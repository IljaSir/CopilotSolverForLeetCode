class Solution {
public:
    int maxStudents(vector<vector<char>>& seats) {
        
        int m = seats.size();
        int n = seats[0].size();
        vector<vector<int>> f(m, vector<int>(1<<n, -1));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '#') {
                    for (int k = 0; k < (1<<n); k++) {
                        if (k & (1<<j)) {
                            f[i][k] = -1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < (1<<n); j++) {
                if (f[i][j] == -1) continue;
                if (i == 0) {
                    f[i][j] = __builtin_popcount(j);
                } else {
                    for (int k = 0; k < (1<<n); k++) {
                        if (f[i-1][k] == -1) continue;
                        if ((j & k) == 0 && (j & (k << 1)) == 0 && (j & (k >> 1)) == 0) {
                            f[i][j] = max(f[i][j], f[i-1][k] + __builtin_popcount(j));
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < (1<<n); i++) {
            ans = max(ans, f[m-1][i]);
        }
        return ans;
    }
};