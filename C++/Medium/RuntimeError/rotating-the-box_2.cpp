class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size(), n = box[0].size();
        vector<vector<char>> res(n, vector<char>(m, '.'));
        for (int i = 0; i < m; ++i) {
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if (box[i][j] == '.') {
                    ++cnt;
                } else if (box[i][j] == '*') {
                    for (int k = 1; k <= cnt; ++k) {
                        res[j - k][i] = '#';
                    }
                    cnt = 0;
                } else {
                    for (int k = 1; k <= cnt; ++k) {
                        res[j - k][i] = '#';
                    }
                    res[j - cnt - 1][i] = '.';
                    cnt = 0;
                }
            }
            for (int k = 1; k <= cnt; ++k) {
                res[n - k][i] = '#';
            }
        }
        return res;
    }
};