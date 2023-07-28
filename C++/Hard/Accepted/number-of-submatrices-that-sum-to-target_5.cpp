class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        
        int m = matrix.size();
        int n = matrix[0].size();
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            vector<int> sum(n, 0);
            for (int j = i; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    sum[k] += matrix[j][k];
                }
                unordered_map<int, int> cnt;
                cnt[0] = 1;
                int s = 0;
                for (int k = 0; k < n; ++k) {
                    s += sum[k];
                    ans += cnt[s - target];
                    cnt[s]++;
                }
            }
        }
        return ans;
    }
};