class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size();
        int n = box[0].size();
        vector<vector<char>> res(n, vector<char>(m, '.'));
        for(int i = 0; i < m; i++) {
            int j = n - 1;
            while(j >= 0 && box[i][j] == '.') {
                j--;
            }
            if(j < 0) {
                continue;
            }
            int k = j;
            while(k >= 0) {
                if(box[i][k] == '#') {
                    res[k][m - i - 1] = '#';
                } else if(box[i][k] == '*') {
                    for(int l = k + 1; l <= j; l++) {
                        res[l][m - i - 1] = '#';
                    }
                    res[k][m - i - 1] = '*';
                    j = k;
                }
                k--;
            }
            for(int l = 0; l <= j; l++) {
                res[l][m - i - 1] = '#';
            }
        }
        return res;
    }
};