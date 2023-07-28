class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size();
        int n = box[0].size();
        vector<vector<char>> ans(n, vector<char>(m, '.'));
        for (int i = 0; i < m; ++i) {
            int j = n - 1;
            while (j >= 0 && box[i][j] == '.') --j;
            int k = j;
            while (j >= 0 && box[i][j] != '*') {
                if (box[i][j] == '#') {
                    ans[k][i] = '#';
                    --k;
                }
                --j;
            }
            while (j >= 0) {
                ans[j][i] = box[i][j];
                --j;
            }
        }
        return ans;
    }
};