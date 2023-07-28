class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size();
        int n = box[0].size();
        vector<vector<char>> res(n, vector<char>(m, '.'));
        for (int i = 0; i < m; i++) {
            int k = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    res[j][m - i - 1] = '*';
                    k = j - 1;
                } else if (box[i][j] == '#') {
                    res[k--][m - i - 1] = '#';
                }
            }
        }
        return res;
    }
};