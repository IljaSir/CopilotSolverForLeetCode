class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int ans = INT_MIN;
        for (int l = 0; l < n; l++) {
            vector<int> row(m, 0);
            for (int r = l; r < n; r++) {
                for (int i = 0; i < m; i++) {
                    row[i] += matrix[i][r];
                }
                set<int> sumSet;
                sumSet.insert(0);
                int sum = 0;
                for (int i = 0; i < m; i++) {
                    sum += row[i];
                    auto it = sumSet.lower_bound(sum - k);
                    if (it != sumSet.end()) {
                        ans = max(ans, sum - *it);
                    }
                    sumSet.insert(sum);
                }
            }
        }
        return ans;
    }
};