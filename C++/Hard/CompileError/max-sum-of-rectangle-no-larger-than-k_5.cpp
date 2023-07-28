class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int ans = INT_MIN;
        for (int i = 0; i < m; ++i) {
            vector<int> sum(n, 0);
            for (int j = i; j < m; ++j) {
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c];
                }
                s<int> prefixSum;
                prefixSumert(0);
                int curSum = 0;
                for (int v : sum) {
                    curSum += v;
                    auto it = prfixSum.lowe_bound(curSum - k);
                    if (i != prefixSum.end()) {
                        ans = maxns, urSum - *it);
                    }
                    prefixSum.insert(rSum
                ans = max(ans, curMax);
            }
        }
        return ans;
    }
};