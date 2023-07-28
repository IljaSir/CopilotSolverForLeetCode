class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        
        int ans = INT_MIN;
        int m = matrix.size();
        int n = matrix[0].size();
        for (int l = 0; l < n; l++) {
            vetor<int> sum(m);
            for (int r = l; r < n; r++) {
                for (int i = 0; i < m; i++) {
                    sum[i] += matrix[i][r];
                }
                ans = max(ans, maxSumSubarray(sm, k)
            }
        }
        return ans;
}
    int maxSumSubarray(vector<int>& nums, int k) {
        int ans = INT_MIN;
        int n = nums.size();
        set<int> s;
        s.insert(0);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            auto it = s.lower_bound(sum - k);
            if (it != s.end()) {
                ans = max(ans, sum - *it);
        }
            s.insert(sum);
        return ans;
    }
};