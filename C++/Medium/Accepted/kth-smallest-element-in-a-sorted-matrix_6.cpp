class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        
        int n = matrix.size();
        int l = matrix[0][0];
        int r = matrix[n-1][n-1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int left = 0;
                int right = n;
                while (left < right) {
                    int mid2 = left + (right - left) / 2;
                    if (matrix[i][mid2] > mid) {
                        right = mid2;
                    } else {
                        left = mid2 + 1;
                    }
                }
                count += left;
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
};