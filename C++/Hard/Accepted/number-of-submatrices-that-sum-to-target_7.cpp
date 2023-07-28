class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        
        int n = matrix.size(), m = matrix[0].size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            vector<int> sum(m, 0);
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    sum[k] += matrix[j][k];
                }
                unordered_map<int, int> mp;
                mp[0] = 1;
                int s = 0;
                for (int k = 0; k < m; k++) {
                    s += sum[k];
                    ans += mp[s - target];
                    mp[s]++;
                }
            }
        }
        return ans;
    }
};