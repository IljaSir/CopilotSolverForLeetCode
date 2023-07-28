class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size();
        int n = box[0].size();
        vector<vector<char>> res(n, vector<char>(m, '.'));
        for (int i = 0; i < m; ++i) {
            int j = n - 1;
            while (j >= 0 && box[i][j] == '.') --j;
            int k = j - 1;
            while (k >= 0) {
                if (box[i][k] == '.') {
                    --k;
                } else if (box[i][k] == '*') {
                    j = k - 1;
                    k = j - 1;
                } else {
                    box[i][j] = '#';
                    box[i][k] = '.';
                    --j;
                    --k;
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[j][i] = box[i][j];
            }
        }
        return res;
    }
};