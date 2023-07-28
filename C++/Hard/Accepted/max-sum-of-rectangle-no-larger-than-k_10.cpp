class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int ans = INT_MIN;
        for (int i = 0; i < m; i++) {
            vector<int> sum(n);
            for (int j = i; j < m; j++) {
                for (int c = 0; c < n; c++) {
                    sum[c] += matrix[j][c];
                }
                set<int> accuSet;
                accuSet.insert(0);
                int accu = 0;
                for (int s : sum) {
                    accu += s;
                    auto it = accuSet.lower_bound(accu - k);
                    if (it != accuSet.end()) {
                        ans = max(ans, accu - *it);
                    }
                    accuSet.insert(accu);
                }
            }
        }
        return ans;
    }
};