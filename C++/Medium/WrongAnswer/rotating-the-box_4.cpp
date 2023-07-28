class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size();
        int n = box[0].size();
        vector<vector<char>> result(n, vector<char>(m, '.'));
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n) {
                if (box[i][j] == '.') {
                    j++;
                    continue;
                }
                if (box[i][j] == '*') {
                    j++;
                    continue;
                }
                int k = j + 1;
                while (k < n && box[i][k] == '.') {
                    k++;
                }
                if (k == n) {
                    break;
                }
                if (box[i][k] == '*') {
                    j = k + 1;
                    continue;
                }
                // box[i][k] == '#'
                result[k][m - i - 1] = '#';
                j = k + 1;
            }
            for (int k = 0; k < j; ++k) {
                result[k][m - i - 1] = box[i][k];
            }
        }
        return result;
    }
};