class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        // 1. sort each diagonal
        // 2. update mat
        int m = mat.size();
        int n = mat[0].size();
        // 3.1 sort first diagonal
        vector<int> diagonal;
        for (int i = 0; i < m; i++) {
            diagonal.push_back(mat[i][0]);
        }
        sort(diagonal.begin(), diagonal.end());
        for (int i = 0; i < m; i++) {
            mat[i][0] = diagonal[i];
        }
        // 3.2 sort second diagonal
        diagonal.clear();
        for (int i = 1; i < n; i++) {
            diagonal.push_back(mat[0][i]);
        }
        sort(diagonal.begin(), diagonal.end());
        for (int i = 1; i < n; i++) {
            mat[0][i] = diagonal[i-1];
        }
        // 3.3 sort other diagonals
        for (int i = 1; i < m; i++) {
            diagonal.clear();
            for (int j = 1; j < n; j++) {
                int x = i;
                int y = j;
                while (x < m && y < n) {
                    diagonal.push_back(mat[x][y]);
                    x++;
                    y++;
                }
                sort(diagonal.begin(), diagonal.end());
                x = i;
                y = j;
                for (int k = 0; k < diagonal.size(); k++) {
                    mat[x][y] = diagonal[k];
                    x++;
                    y++;
                }
                break
     = 0;
            c = i;
            int j = 0;
            while (r < m && c < n) {
                mat[r][c] = tmp[j];
                r++;
                c++;
                j++;
            }
        }
        return mat;
    }
};