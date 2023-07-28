class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size(), n = box[0].size();
        vector<vector<char>> ans(n, vector<char>(m));
        for (int i = 0; i < m; ++i) {
            int j = n - 1, k = n - 1;
            while (j >= 0) {
                if (box[i][j] != '.') {
                    if (box[i][j] == '*') {
                        k = j - 1;
                    } else {
                        ans[k][m - 1 - i] = '#';
                        --k;
                    }
                }
                --j;
            }
        }
        return ans;
    }
};