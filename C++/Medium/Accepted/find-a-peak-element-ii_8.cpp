class Solution {
public:
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        int l = 0;
        int r = m - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (mat[mid][i] > mat[mid][maxIndex]) {
                    maxIndex = i;
                }
            }
            if (mid == 0) {
                if (mat[mid][maxIndex] > mat[mid + 1][maxIndex]) {
                    return {mid, maxIndex};
                } else {
                    l = mid + 1;
                }
            } else if (mid == m - 1) {
                if (mat[mid][maxIndex] > mat[mid - 1][maxIndex]) {
                    return {mid, maxIndex};
                } else {
                    r = mid - 1;
                }
            } else {
                if (mat[mid][maxIndex] > mat[mid - 1][maxIndex] && mat[mid][maxIndex] > mat[mid + 1][maxIndex]) {
                    return {mid, maxIndex};
                } else if (mat[mid][maxIndex] < mat[mid - 1][maxIndex]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return {};
    }
};