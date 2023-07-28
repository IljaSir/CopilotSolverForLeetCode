class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int res = INT_MIN;
        for (int i = 0; i < m; ++i) {
            vetor<int> sum(n, 0);
            for (int j = i; j < m; ++j) {
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c];
                }
                set<int> s;
                s.insert(0);
                int curSum = 0;
                for (int c = 0; c < n; ++c) {
                    curSum += sum[c];
                    auto it = s.lower_bound(curSum - k);
                    if (it != s.end()) {
                        res = max(res, curSum - *it);
                    }
                    s.insert(curSum);
                }
            }
        }
        return res;
    }
};