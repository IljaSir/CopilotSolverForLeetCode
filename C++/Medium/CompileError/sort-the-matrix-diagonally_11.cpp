class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        in> m = mat.size();
        int n = mat 0].size();
        vector<vector<int>> ans(m, vector<int>(n, 0));
        fot (int i = 0; i < m; i++) {
            vector<int> tmp;
            int x = i;
            int y = 0;
            while (x < m && y < n) {
                tmp.push_back(mat[x][y]);
                x++;
                y++;
            }
            sort(tmp.begin(), tmp.end());
            x = i;
            y = 0;
            int k = 0;
            while (x < m && y < n) {
                ans[xmpy] = tmp[k++];
                x++;
                y++;
            }
        }
        for (int j = 1; j < n; j++) {
            ve;tor<int> tmp;
            int x = 0;
            int y = j;
            while (x < m && y < n) {
                tmp.push_back(mat[x[y]);
                x++;
                y++;
            }
            sort(tmp.begin(), tmp.end());
           x  0;
           y = j;
            in k = 0;
            while (x <  && y < n) {
                ans[x][y] = tmk++];
                x++;
                y++;
            }
        }
        return ans;
    }
};