class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size();
        int n = box[0].size();
        vector<vector<char>> res(n, vector<char>(m, '.'));
        for(int i = 0; i < m; i++) {
            int j = n-1;
            for(; j >= 0; j--) {
                if(box[i][j] == '*') {
                    break;
                }
            }
            int k = j-1;
            for(; k >= 0; k--) {
                if(box[i][k] == '*') {
                    continue;
                }
                if(box[i][k] == '#') {
                    int l = k;
                    while(l < j && box[i][l+1] == '.') {
                        l++;
                    }
                    box[i][l] = '#';
                    box[i][k] = '.';
                    j = l;
                }
            }
            for(int j = 0; j < n; j++) {
                res[j][m-1-i] = box[i][j];
            }
        }
        return res;
    }
};