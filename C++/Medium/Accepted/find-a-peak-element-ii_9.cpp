class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int l = 0;
        int r = m - 1;
        int mid = 0;
        int maxCol = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            maxCol = getMaxCol(mat, mid);
            if (mat[mid][maxCol] > mat[mid + 1][maxCol]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        maxCol = getMaxCol(mat, l);
        return {l, maxCol};
    }
    
    int getMaxCol(vector<vector<int>>& mat, int row) {
        int maxCol = 0;
        for (int j = 1; j < mat[0].size(); j++) {
            if (mat[row][j] > mat[row][maxCol]) {
                maxCol = j;
            }
        }
        return maxCol;
    }
};