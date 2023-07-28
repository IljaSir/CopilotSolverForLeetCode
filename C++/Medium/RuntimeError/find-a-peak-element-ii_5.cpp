class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        int m = mat.size(), n = mat[0].size();
        int left = 0, right = m - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int maxCol = 0;
            for (int j = 1; j < n; ++j)
                if (mat[mid][j] > mat[mid][maxCol]) maxCol = j;
            if (mat[mid][maxCol] < mat[mid + 1][maxCol]) left = mid + 1;
            else if (mat[mid][maxCol] < mat[mid - 1][maxCol]) right = mid - 1;
            else return vector<int>{mid, maxCol};
        }
        int maxCol = 0;
        for (int j = 1; j < n; ++j)
            if (mat[left][j] > mat[left][maxCol]) maxCol = j;
        return vector<int>{left, maxCol};
    }
};