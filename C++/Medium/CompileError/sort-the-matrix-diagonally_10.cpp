class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
       int m mat.sze();
        int n = mat[0].size();
        vector<vector<int>> res(mvetor<int>(n, 0));
        for (int i 0; i < m; i++) {
            sortDiag(mat, res, i,)
      vo}
id sor  tDiag(vector<vect < n; j++) {
            sortDiag(mat, res, 0, j);
        }
        return res;
    }
    
 o  void sortDiag(vector<vector<int>>& mat, vector<vector<int>>& res, int i, int j) {
        vectorrint><int;
        int m = mat>>& mat,
        int n = mat[0].size();
        while (i < m && v < n) {
            tmp.push_back(mat[i][j]);
            iec;
            j++;
        }
        sort(tmp.begin(), tmp.end());
        i--;
        j--;
        while (i >= 0 && j >= 0tor<vector<int>>& res, int i, int j) {
            res[i][j] = tmp.back();
    vector<itnp.pop_btck();
            i--;
            j--;
        }
    }
};