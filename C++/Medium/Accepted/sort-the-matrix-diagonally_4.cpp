class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        for (int i = 0; i < m; i++) {
            vector<int> temp;
            int x = i, y = 0;
            while (x < m && y < n) {
                temp.push_back(mat[x][y]);
                x++;
                y++;
            }
            sort(temp.begin(), temp.end());
            x = i;
            y = 0;
            for (int j = 0; j < temp.size(); j++) {
                mat[x][y] = temp[j];
                x++;
                y++;
            }
        }
        for (int i = 1; i < n; i++) {
            vector<int> temp;
            int x = 0, y = i;
            while (x < m && y < n) {
                temp.push_back(mat[x][y]);
                x++;
                y++;
            }
            sort(temp.begin(), temp.end());
            x = 0;
            y = i;
            for (int j = 0; j < temp.size(); j++) {
                mat[x][y] = temp[j];
                x++;
                y++;
            }
        }
        return mat;
    }
};