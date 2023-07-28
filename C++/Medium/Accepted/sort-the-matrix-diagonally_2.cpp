class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> res(m, vector<int>(n, 0));
        for (int i = 0; i < m; i++) {
            sortDiag(mat, res, i, 0);
        }
        for (int j = 0; j < n; j++) {
            sortDiag(mat, res, 0, j);
        }
        return res;
    }
    
    void sortDiag(vector<vector<int>>& mat, vector<vector<int>>& res, int i, int j) {
        vector<int> tmp;
        int m = mat.size();
        int n = mat[0].size();
        while (i < m && j < n) {
            tmp.push_back(mat[i][j]);
            i++;
            j++;
        }
        sort(tmp.begin(), tmp.end());
        i--;
        j--;
        while (i >= 0 && j >= 0) {
            res[i][j] = tmp.back();
            tmp.pop_back();
            i--;
            j--;
        }
    }
};