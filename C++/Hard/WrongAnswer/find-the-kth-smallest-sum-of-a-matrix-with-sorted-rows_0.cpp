class Solution {
public:
    int kthSmallest(vector<vector<int>>& mat, int k) {
        
        int m = mat.size();
        int n = mat[0].size();
        vector<int> sum(m, 0);
        for (int i = 0; i < m; ++i) {
            sum[i] = mat[i][0];
        }
        set<int> sums;
        sums.insert(accumulate(sum.begin(), sum.end(), 0));
        for (int i = 0; i < n; ++i) {
            vector<int> nextSum = sum;
            for (int j = 0; j < m; ++j) {
                nextSum[j] = sum[j] + mat[j][i] - mat[j][0];
            }
            sums.insert(accumulate(nextSum.begin(), nextSum.end(), 0));
            sum = nextSum;
        }
        auto it = sums.begin();
        for (int i = 1; i < k; ++i) {
            ++it;
        }
        return *it;
    }
};