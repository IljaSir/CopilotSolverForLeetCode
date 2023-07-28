class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        
        int m = matrix.size(), n = matrix[0].size();
        int ans = INT_MIN;
        for (int i = 0; i < m; i++) {
            vector<int> sum(n);
            for (int j = i; j < m; j++) {
                for (int c = 0; c < n; c++) {
                    sum[c] += matrix[j][c];
                }
                set<int> accuSet{0};
                int accu = 0, curMax = INT_MIN;
                for (int v : sum) {
                    accu += v;
                    auto lb = accuSet.lower_bound(accu - k);
                    if (lb != accuSet.end()) {
                        curMax = max(curMax, accu - *lb);
                    } accu - *it);
                    }
                    accuSet.insert(accu);
                }
            }
        }
        return ans;
    }
};