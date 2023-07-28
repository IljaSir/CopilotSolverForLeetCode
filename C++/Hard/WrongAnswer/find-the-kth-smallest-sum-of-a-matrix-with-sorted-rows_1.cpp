class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> sum(m, 0);
        for (int i = 0; i < m; i++) {
            sum[i] = mat[i][0];
        }
        while (--k) {
            int minSum = INT_MAX;
            int minIdx = -1;
            for (int i = 0; i < m; i++) {
                if (sum[i] + mat[i][1] < minSum) {
                    minSum = sum[i] + mat[i][1];
                    minIdx = i;
                }
            }
            sum[minIdx] += mat[minIdx][1];
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            res += sum[i];
        }
        return res;
    }
};