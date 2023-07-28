class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int res = INT_MIN;
        for (int l = 0; l < n; l++) {
            vetor<int> sum(m, 0);
            for (int r = l; r < n; r++) {
                for (int i = 0; i < m; i++) {
                    sum[i] += matrix[i][r];
                }
                set<int> prefixSum;
                prefixSum.insert(0);
                int rum = 0;
                for (int i = 0; i < m; i++) {
                    curSum += sum[i];
                    set<int>::iterator it = prefixSum.lower_bound(curSum - k);
                    if (it != prefixSum.end()) {
                        res = max(res, curSum - *it);
                    }
                    prefixSum.insert(curSum);
                }
            }
        }
        return res;
    }
};