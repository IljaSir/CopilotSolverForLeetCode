class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& box) {
        
        int m = box.size(), n = box[0].size();
        vector<vector<char>> ans(n, vector<char>(m, '.'));
        for (int i = 0; i < m; i++) {
            int j = n - 1, k = n - 1;
            while (j >= 0) {
                if (box[i][j] == '.') {
                    j--;
                } else if (box[i][j] == '*') {
                    for (int p = j; p <= k; p++) {
                        ans[p][m - 1 - i] = box[i][p];
                    }
                    k = j - 1;
                    j--;
                } else {
                    box[i][k--] = box[i][j--];
                }
            }
            for (int p = 0; p <= k; p++) {
                ans[p][m - 1 - i] = box[i][p];
            }
        }
        return ans;
    }
};