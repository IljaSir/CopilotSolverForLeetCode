class Solution {
public:
    int minCut(string s) {
        
        // 动态规划
        int n = s.size();
        vector<int> f(n+1, 0);
        vector<vector<bool>> g(n, vector<bool>(n, false));
        for (int i = 0; i <= n; i++) {
            f[i] = n - i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s[i] == s[j] && (j - i < 2 || g[i+1][j-1])) {
                    g[i][j] = true;
                    f[i] = min(f[i], f[j+1] + 1);
                }
            }
        }
        return f[0] - 1
                }
            }
        }
        return dp2[0];
    }
};