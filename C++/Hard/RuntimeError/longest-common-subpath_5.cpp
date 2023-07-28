class Solution {
public:
    int longestCommonSubpath(int n, vector<vector<int>>& paths) {
        
        int m = paths.size();
        vector<vector<int>> pre(m);
        vector<int> cnt(n);
        int res = 0;
        for (int i = 0; i < m; i++) {
            int sz = paths[i].size();
            pre[i].resize(sz + 1);
            for (int j = 0; j < sz; j++) {
                pre[i][j + 1] = pre[i][j] ^ (1 << paths[i][j]);
            }
        }
        for (int i = 1; i <= paths[0].size(); i++) {
            int l = 0, r = i;
            while (r <= paths[0].size()) {
                int cur = pre[0][r] ^ pre[0][l];
                for (int j = 1; j < m; j++) {
                    if ((pre[j][r] ^ pre[j][l]) != cur) {
                        cur = -1;
                        break;
                    }
                }
                if (cur != -1) {
                    res = i;
                    break;
                }
                l++;
                r++;
            }
        }
        return res;
    }
};